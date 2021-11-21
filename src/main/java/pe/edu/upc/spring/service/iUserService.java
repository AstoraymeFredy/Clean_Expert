package pe.edu.upc.spring.service;

import java.util.Optional;

import pe.edu.upc.spring.model.UserModel;

public interface iUserService {
	public boolean createUser (UserModel user);
	public Optional<UserModel> findByUsernameRepeated(String username);
}
