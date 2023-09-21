package pedrogabriel.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pedrogabriel.service.UserService;
import pedrogabriel.model.User;

@RestController
public class UserController {
	
	private final UserService userService;
	
	UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		var user = userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAll() {
		var users = userService.findAll();
		return ResponseEntity.ok(users);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody User userToUpdate) {
		var updatedUser = userService.update(id ,userToUpdate);
		return ResponseEntity.ok(updatedUser);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> create(@RequestBody User userToCreate) {
		var userCreated = userService.create(userToCreate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("users/{id}")
				.buildAndExpand(userCreated.getId())
				.toUri();
		return ResponseEntity.created(location).body(userCreated);
	}
	

	@DeleteMapping("users/{id}")
	public ResponseEntity<User> delete(@PathVariable Long id) {
		var userTodelete = userService.delete(id);
		return ResponseEntity.ok(userTodelete);
	}
	
}
