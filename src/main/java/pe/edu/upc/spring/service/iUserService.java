package pe.edu.upc.spring.service;

import java.util.Optional;

import pe.edu.upc.spring.model.User;

public interface iUserService {
	public boolean createUser (User user);
	public Optional<User> findByUsernameAndPassword(String username, String password);

}
