package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.model.Parameter;

public interface iParameterService {
	
	public boolean createParameter(Parameter parameter);
	public Parameter listId(int id_parameter);
	List<Parameter> list();
}
