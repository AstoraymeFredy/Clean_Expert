package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Client;

@Repository
public interface iClientRepository extends JpaRepository<Client, Integer> {
	
	@Query("from Client c where c.name like %:nameClient%")
	List<Client> searchByName(@Param("nameClient") String nameClient);
	
	@Query("from Client c where c.user.id_user=:idUser")
	Client findByUserId(int idUser);
	
	@Query(value = "SELECT c.id_client, c.nombre, c.apellidos ,count(r.id_reservation),sum(r.precio)"
			+ " from cliente c join propiedad p on c.id_client=p.id_cliente"
			+ " join reserva r on r.id_propiedad=p.id_property"
			+ " group by c.id_client"
			+ " ORDER BY count(r.id_reservation)  DESC "
			+ " limit 5", nativeQuery = true)
	public List<String[]> clientReport();
	
	@Query(value = "SELECT c.id_client, c.nombre, c.apellidos,count(r.id_reservation),sum(r.precio)"
			+ " from cliente c join propiedad p on c.id_client=p.id_cliente"
			+ " join reserva r on r.id_propiedad=p.id_property"
			+ " where date_part('month', r.fecha) = :month" 
			+ " group by c.id_client"
			+ " ORDER BY count(r.id_reservation)  DESC "
			+ " limit 5", nativeQuery = true)
	public List<String[]> clientReportbyMonth(int month);
}