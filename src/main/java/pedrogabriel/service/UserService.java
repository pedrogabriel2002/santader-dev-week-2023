package pedrogabriel.service;

import pedrogabriel.model.User;

public interface UserService {

	User findById(Long id);
	
	User create(User userToCreate);
}
