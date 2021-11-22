package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.repository.iClientRepository;
import pe.edu.upc.spring.service.iClientService;

@Service
public class ClientServiceImpl implements iClientService {
	
	@Autowired
	private iClientRepository dClient;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public boolean createClient(Client client) {
		client.getUser().setPassword(passwordEncoder.encode(client.getUser().getPassword()));
		Client objClient = dClient.save(client);
		if(objClient==null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	@Transactional
	public boolean updateClient(Client client) {
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
	public Client findById(int idClient) {
		return dClient.findById(idClient).get();
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
	public Client findByUserId(int idUser) {
		return dClient.findByUserId(idUser);
	}

	@Override
	public List<String[]> clientReport(int month) {	
		
		if(month>0) {
			
			return dClient.clientReportbyMonth(month);
		}
		else
			
			return dClient.clientReport();	
	}
	
}
