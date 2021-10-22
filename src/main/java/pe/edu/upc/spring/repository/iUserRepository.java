package pe.edu.upc.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.User;

@Repository
public interface iUserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsernameAndPassword(String username,String password);
	
}
