package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoUsuario")
public class TypeUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_type_user;
	
	@Column(name="nombre", nullable=false, length=30)
	private String name;

	public TypeUser() {
		super();
	}

	public TypeUser(int id_type_user, String name) {
		super();
		this.id_type_user = id_type_user;
		this.name = name;
	}

	public int getId_type_user() {
		return id_type_user;
	}

	public void setId_type_user(int id_tipo_usuario) {
		this.id_type_user = id_tipo_usuario;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
