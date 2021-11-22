package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.model.Client;

public interface iClientService {
	public boolean createClient(Client client);
	public boolean updateClient(Client client);
	public void deleteClient(int idClient);
	public Client findById(int idClient);
	public Client findByUserId(int idUser);
	public List<Client> listClient();
	public List<Client> searchClient(String nameClient);
	public List<String[]> clientReport(int month);
	
	
}
