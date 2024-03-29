package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Parameter;

@Repository
public interface iParameterRepository extends JpaRepository<Parameter, Integer> {

	public List<Parameter> findAllByOrderByIdParameterAsc();

}
