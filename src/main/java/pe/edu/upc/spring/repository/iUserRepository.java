package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.UserModel;

@Repository
public interface iUserRepository extends JpaRepository<UserModel, Integer> {

	public UserModel findByUsername(String username);
	
	@Query("from UserModel u where u.username = :username")
	UserModel findByUsernameRepeated(@Param("username") String username);
	
}
