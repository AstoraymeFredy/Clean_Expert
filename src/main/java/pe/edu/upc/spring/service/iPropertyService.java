package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Property;

public interface iPropertyService {
	
	public boolean createProperty(Property property);
	public void deleteProperty(int idProperty);
	public Optional<Property> findById(int idProperty);
	public List<Property> findByClientId (int idClient);
}
