package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.model.Admin;

public interface iAdminService {
	public boolean createAdmin(Admin admin);
	public Admin findById(int idAdmin);
	public Admin findByUserId(int idUser);
	public List<Admin> listAdmin();
	public List<Admin> searchAdmin(String nameAdmin);
	
}
