package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Propiedad")
public class Property implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_property;
	
	@Column(name="direccion", nullable=false, length=150)
	private String address;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_distrito", nullable=false)
	private District district;

	public Property(int id_property, String address, Client client, District district) {
		super();
		this.id_property = id_property;
		this.address = address;
		this.client = client;
		this.district = district;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_property() {
		return id_property;
	}

	public void setId_property(int id_property) {
		this.id_property = id_property;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
	
}
