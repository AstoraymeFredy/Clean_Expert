package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.model.Property;

public interface iPropertyService {
	
	public boolean createProperty(Property property);
	public void deleteProperty(int idProperty);
	public Property findById(int idProperty);
	public List<Property> findByClientId (int idClient);
}
