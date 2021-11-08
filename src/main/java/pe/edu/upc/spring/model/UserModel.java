package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_user;
	
	@Column(name="username", nullable=false, length=50, unique = true)
	private String username;
	
	@Column(name="password", nullable=false, length=50, unique = true)
	private String password;
	
	@OneToOne
	@JoinColumn(name="id_tipo_usuario", nullable=false)
	private TypeUser type_user;

	public UserModel() {
		super();
	}

	public UserModel(int id_user, String username, String password, TypeUser type_user) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.type_user = type_user;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypeUser getType_user() {
		return type_user;
	}

	public void setType_user(TypeUser type_user) {
		this.type_user = type_user;
	}
	
	
	
}
