package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Admin;

public interface iAdminService {
	public boolean createAdmin(Admin admin);
	public Optional<Admin> findById(int idAdmin);
	public Optional<Admin> findByUserId(int idUser);
	public List<Admin> listAdmin();
	public List<Admin> searchAdmin(String nameAdmin);
}
