package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.repository.iClientRepository;
import pe.edu.upc.spring.service.iClientService;

@Service
public class ClientServiceImpl implements iClientService {
	
	@Autowired
	private iClientRepository dClient;
	
	@Override
	@Transactional
	public boolean createClient(Client client) {
		System.out.println(client.getId_client());
		Client objClient = dClient.save(client);
		if(objClient==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public void deleteClient(int idClient) {
		dClient.deleteById(idClient);
	}

	@Override
	public Optional<Client> findById(int idClient) {
		return dClient.findById(idClient);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Client> listClient() {
		return dClient.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Client> searchClient(String nameClient) {
		return dClient.searchByName(nameClient);
	}

	@Override
	public Optional<Client> findByUserId(int idUser) {
		return dClient.findByUserId(idUser);
	}
	
}
