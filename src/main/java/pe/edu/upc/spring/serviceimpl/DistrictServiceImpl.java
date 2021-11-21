package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.District;
import pe.edu.upc.spring.repository.iDistrictRepository;
import pe.edu.upc.spring.service.iDistrictService;

@Service
public class DistrictServiceImpl implements iDistrictService{

	@Autowired
	private iDistrictRepository dDistrict;
	
	@Override
	@Transactional(readOnly = true)
	public List<District> listDistrict() {
		return dDistrict.findAll();
	}

	@Override
	public List<String[]> generalReport(int month) {
		if (month > 0) {
			return dDistrict.generalReportByMonth(month);
		} else {
			return dDistrict.generalReport();
		}
		
	}

	@Override
	public List<String[]> generalHeaderReport(int month) {
		if (month > 0) {
			return dDistrict.generalHeaderReportByMonth(month);
		} else {
			return dDistrict.generalHeaderReport();
		}
	}
}
