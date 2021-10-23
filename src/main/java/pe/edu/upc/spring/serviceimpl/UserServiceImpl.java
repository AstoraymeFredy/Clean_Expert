package pe.edu.upc.spring.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.User;
import pe.edu.upc.spring.repository.iUserRepository;
import pe.edu.upc.spring.service.iUserService;

@Service
public class UserServiceImpl implements iUserService {
	
	@Autowired
	private iUserRepository dUser;

	@Override
	@Transactional
	public boolean createUser(User user) {
		User objUser = dUser.save(user);
		if(objUser==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Optional<User> findByUsernameAndPassword(String username, String password) {
		return dUser.findByUsernameAndPassword(username, password);
	}
	
}
