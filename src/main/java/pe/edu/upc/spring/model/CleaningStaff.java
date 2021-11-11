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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="PersonalLimpieza")
public class CleaningStaff implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_cleaning_staff;
	
	@NotEmpty(message = "Ingrese su nombre")
	@Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números")
	@Column(name="nombre", nullable=false, length=80)
	private String name;
	
	@NotEmpty(message = "Ingrese su apellido")
	@Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números")
	@Column(name="apellidos", nullable=false, length=100)
	private String lastname;
	
	@NotEmpty(message = "Ingrese una descripción")
	@Column(name="descripcion", nullable=false, length=150)
	private String description;
	
	@Email(message = "El correo no es válido", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Ingrese su correo")
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@Size(min = 9, max = 9, message = "El celular de tener 9 dígitos")
	@Pattern(regexp = "[0-9]+", message = "El celular debe contener solo números")
	@NotEmpty(message = "Ingrese su celular")
	@Column(name="celular", nullable=false, length=20)
	private String phone;
	
	@Column(name="habilitado", nullable=false)
	private boolean enabled;
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private UserModel user;

	public CleaningStaff() {
		super();
	}

	public CleaningStaff(int id_cleaning_staff, String name, String lastname, String description, String email,
			String phone, boolean enabled, UserModel user) {
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

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	
	
	
	
}
