package pedrogabriel.service;

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

}
