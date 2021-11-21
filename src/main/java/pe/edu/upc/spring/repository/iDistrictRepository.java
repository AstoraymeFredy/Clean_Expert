package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.District;

@Repository
public interface iDistrictRepository extends JpaRepository<District, Integer>{
	
	@Query(value = "SELECT d.id_district, d.nombre,count(r.id_reservation)"
			+ " from propiedad p join distrito d on d.id_district=p.id_distrito"
			+ " join reserva r on r.id_propiedad=p.id_property"
			+ " group by d.id_district"
			+ " ORDER BY count(r.id_reservation)  DESC "
			+ " limit 5", nativeQuery = true)
	public List<String[]> generalReport();
	
	@Query(value = "SELECT count(*), sum(price) FROM Reservation")
	public List<String[]> generalHeaderReport();
	
	@Query(value = "SELECT d.id_district, d.nombre,count(r.id_reservation)"
			+ " from propiedad p join distrito d on d.id_district=p.id_distrito"
			+ " join reserva r on r.id_propiedad=p.id_property"
			+ " where date_part('month', r.fecha) = :month" 
			+ " group by d.id_district"
			+ " ORDER BY count(r.id_reservation)  DESC "
			+ " limit 5", nativeQuery = true)
	public List<String[]> generalReportByMonth(int month);
	
	@Query(value = "SELECT count(*), sum(price) FROM Reservation r where date_part('month', r.date) = :month")
	public List<String[]> generalHeaderReportByMonth(int month);
	
}
