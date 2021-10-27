package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PersonalLimpieza")
public class CleaningStaff implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_cleaning_staff;
	
	@Column(name="nombre", nullable=false, length=80)
	private String name;
	
	@Column(name="apellidos", nullable=false, length=100)
	private String lastname;
	
	@Column(name="descripcion", nullable=false, length=150)
	private String description;
	
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@Column(name="celular", nullable=false, length=20)
	private String phone;
	
	@Column(name="habilitado", nullable=false)
	private boolean enabled;
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private User user;

	public CleaningStaff() {
		super();
	}

	public CleaningStaff(int id_cleaning_staff, String name, String lastname, String description, String email,
			String phone, boolean enabled, User user) {
		super();
		this.id_cleaning_staff = id_cleaning_staff;
		this.name = name;
		this.lastname = lastname;
		this.description = description;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
		this.user = user;
	}

	public int getId_cleaning_staff() {
		return id_cleaning_staff;
	}

	public void setId_cleaning_staff(int id_cleaning_staff) {
		this.id_cleaning_staff = id_cleaning_staff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
}
