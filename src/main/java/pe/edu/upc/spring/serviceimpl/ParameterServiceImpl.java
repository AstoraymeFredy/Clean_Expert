package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Parameter;
import pe.edu.upc.spring.repository.iParameterRepository;
import pe.edu.upc.spring.service.iParameterService;

@Service
public class ParameterServiceImpl implements iParameterService{
	
	@Autowired
	private iParameterRepository dParameter;

	@Override
	@Transactional
	public boolean createParameter(Parameter parameter ) {
		Parameter objParameter = dParameter.save(parameter);
		if (objParameter == null)
			return false;
		else
			return true;
	}
	@Override
	@Transactional(readOnly = true)
	public Parameter listId(int id_parameter) {
		return dParameter.findById(id_parameter).get();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Parameter> list() {
		return dParameter.findAllByOrderByIdParameterAsc();
	}

}
