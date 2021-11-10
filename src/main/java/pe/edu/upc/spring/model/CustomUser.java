package pe.edu.upc.spring.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	private static final long serialVersionUID = 1L;
	
	private final int userID;
	
	private final int typeUserID;

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
                      boolean credentialsNonExpired,
                      boolean accountNonLocked,
                      Collection<? extends GrantedAuthority> authorities, int userID, int typeUserID) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userID = userID;
        this.typeUserID = typeUserID;
    }

	public int getUserID() {
		return userID;
	}

	public int getTypeUserID() {
		return typeUserID;
	}
}
