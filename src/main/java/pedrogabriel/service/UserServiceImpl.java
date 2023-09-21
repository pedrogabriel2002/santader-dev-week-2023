package pedrogabriel.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import pedrogabriel.model.User;
import pedrogabriel.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
			throw new IllegalArgumentException("This user ID already exists");
		}
		return userRepository.save(userToCreate);
	}

	@Override
	public List<User> findAll() {
		List<User> allUsers = userRepository.findAll();
		if (allUsers.isEmpty()) {
			throw new NoSuchElementException("There is no users on the database");
		}
		return allUsers;
	}

	@Override
	public User update(Long id, User userToUpdate) {
		User userFromDb = this.findById(id);
		System.out.println(userToUpdate.getId());
		System.out.println(userFromDb.getId());
		if (!userFromDb.getId().equals(userToUpdate.getId())) {
			throw new IllegalArgumentException("It has to be the same ID");
		}
		
		userFromDb.setName(userToUpdate.getName());
		userFromDb.setAccount(userToUpdate.getAccount());
		userFromDb.setCard(userToUpdate.getCard());
		userFromDb.setFeatures(userToUpdate.getFeatures());
		userFromDb.setNews(userToUpdate.getNews());
		
		return this.userRepository.save(userFromDb);
	}

	@Override
	public User delete(Long id) {
		User userToDelete = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
		
		userRepository.delete(userToDelete);
		return userToDelete;
		
	}
	

}
