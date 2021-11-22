package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="parametro")
public class Parameter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idParameter;
	
	@Column(name="nombre", nullable=false, length=50)
	private String name;
	
	@Range(min = 1, message="El campo debe ser mayor a 1")
	@NotNull(message = "Ingresa un valor")
	@Column(name="valor", nullable=false)
	private Integer value;
	
	@Column(name="unidad", nullable=false, length=50)
	private String unit;

	public Parameter() {
		super();
	}

	public Parameter(int id_parameter, String name, Integer value, String unit) {
		super();
		this.idParameter = id_parameter;
		this.name = name;
		this.value = value;
		this.unit = unit;
	}

	public int getId_parameter() {
		return idParameter;
	}

	public void setId_parameter(int id_parameter) {
		this.idParameter = id_parameter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
