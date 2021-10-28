package pe.edu.upc.spring.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import pe.edu.upc.spring.model.Admin;
import pe.edu.upc.spring.model.CleaningStaff;
import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.model.User;

@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Sesion {
	
	private User user;
	private Client client;
	private CleaningStaff cleaningStaff;
	private Admin admin;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CleaningStaff getCleaningStaff() {
		return cleaningStaff;
	}

	public void setCleaningStaff(CleaningStaff cleaningStaff) {
		this.cleaningStaff = cleaningStaff;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	
}
