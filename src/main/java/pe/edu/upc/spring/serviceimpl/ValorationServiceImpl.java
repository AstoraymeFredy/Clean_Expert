package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Valoration;
import pe.edu.upc.spring.repository.iValorationRepository;
import pe.edu.upc.spring.service.iValorationService;

@Service
public class ValorationServiceImpl implements iValorationService{
	
	@Autowired
	private iValorationRepository dValoration;

	@Override
	@Transactional
	public boolean createValoration(Valoration valoration) {
		Valoration objValoration= dValoration.save(valoration);
		if (objValoration == null)
			return false;
		else
			return true;
	}
	@Override
	@Transactional(readOnly = true)
	public Valoration listId(int id_valoration) {
		return dValoration.findById(id_valoration).get();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Valoration> list() {
		return dValoration.findAll();
	}

}
