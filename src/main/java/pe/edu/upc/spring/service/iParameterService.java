package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Parameter;

public interface iParameterService {
	
	public boolean CreateParameter(Parameter parameter);
	public Optional<Parameter> listId(int id_parameter);
	List<Parameter> list();
}
