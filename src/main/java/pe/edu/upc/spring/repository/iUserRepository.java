package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.UserModel;

@Repository
public interface iUserRepository extends JpaRepository<UserModel, Integer> {

	public UserModel findByUsername(String username);
	
}
