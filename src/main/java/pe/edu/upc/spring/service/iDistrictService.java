package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.model.District;

public interface iDistrictService {

	public List<District> listDistrict();
	public List<String[]> generalReport();
	public List<String[]> generalHeaderReport();
}
