package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Client;

public interface iClientService {
	public boolean createClient(Client client);
	public boolean updateClient(Client client);
	public void deleteClient(int idClient);
	public Optional<Client> findById(int idClient);
	public Optional<Client> findByUserId(int idUser);
	public List<Client> listClient();
	public List<Client> searchClient(String nameClient);
	
}
