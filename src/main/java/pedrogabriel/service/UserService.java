package pedrogabriel.service;

import java.util.List;

import pedrogabriel.model.User;

public interface UserService {

	User findById(Long id);
	
	User create(User userToCreate);
	
	List<User> findAll();
	
	User update(Long id, User userToUpdate);
	
	User delete(Long id);
}
