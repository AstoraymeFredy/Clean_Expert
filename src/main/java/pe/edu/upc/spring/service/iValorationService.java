package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Valoration;

public interface iValorationService {
	
	public boolean createValoration(Valoration valoration);
	public Optional<Valoration> listId(int id_valoration);
	List<Valoration> list();
}
