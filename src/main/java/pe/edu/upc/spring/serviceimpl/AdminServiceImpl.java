package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Admin;
import pe.edu.upc.spring.repository.iAdminRepository;
import pe.edu.upc.spring.service.iAdminService;

@Service
public class AdminServiceImpl implements iAdminService {
	
	@Autowired
	private iAdminRepository dAdmin;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public boolean createAdmin(Admin admin) {
		admin.getUser().setPassword(passwordEncoder.encode(admin.getUser().getPassword()));
		Admin objAdmin = dAdmin.save(admin);
		if(objAdmin==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Admin findById(int idAdmin) {
		return dAdmin.findById(idAdmin).get();
	}

	@Override
	public Admin findByUserId(int idUser) {
		return dAdmin.findByUserId(idUser);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Admin> listAdmin() {
		return dAdmin.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Admin> searchAdmin(String nameAdmin) {
		return dAdmin.searchByName(nameAdmin);
	}


}
