package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parametro")
public class Parameter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_parameter;
	
	@Column(name="nombre", nullable=false, length=50)
	private String name;
	
	@Column(name="valor", nullable=false, length=50)
	private int value;
	
	@Column(name="unidad", nullable=false, length=50)
	private String unit;

	public Parameter() {
		super();
	}

	public Parameter(int id_parameter, String name, int value, String unit) {
		super();
		this.id_parameter = id_parameter;
		this.name = name;
		this.value = value;
		this.unit = unit;
	}

	public int getId_parameter() {
		return id_parameter;
	}

	public void setId_parameter(int id_parameter) {
		this.id_parameter = id_parameter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
}
