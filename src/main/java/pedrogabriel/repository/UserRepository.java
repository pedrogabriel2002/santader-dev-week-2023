package pedrogabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pedrogabriel.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}