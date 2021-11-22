package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Property;
import pe.edu.upc.spring.repository.iPropertyRepository;
import pe.edu.upc.spring.service.iPropertyService;

@Service
public class PropertyServiceImpl implements iPropertyService{

	@Autowired
	private iPropertyRepository dProperty;
	
	@Override
	@Transactional
	public boolean createProperty(Property property) {
		Property objProperty = dProperty.save(property);
		if(objProperty==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public void deleteProperty(int idProperty) {
		dProperty.deleteById(idProperty);
	}

	@Override
	@Transactional(readOnly = true)
	public Property findById(int idProperty) {
		return dProperty.findById(idProperty).get();
	}	
	
	@Override
	@Transactional(readOnly = true)
	public List<Property> findByClientId(int idClient) {
		return dProperty.findByClientId(idClient);
	}
}
