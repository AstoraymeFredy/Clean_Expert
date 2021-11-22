package pe.edu.upc.spring.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.UserModel;
import pe.edu.upc.spring.repository.iUserRepository;
import pe.edu.upc.spring.service.iUserService;

@Service
public class UserServiceImpl implements iUserService {
	
	@Autowired
	private iUserRepository dUser;

	@Override
	@Transactional
	public boolean createUser(UserModel user) {
		UserModel objUser = dUser.save(user);
		if(objUser==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public UserModel findByUsernameRepeated(String username) {
		System.out.println(username);
		return dUser.findByUsernameRepeated(username);
	}

	
}
