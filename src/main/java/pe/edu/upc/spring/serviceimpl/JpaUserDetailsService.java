package pe.edu.upc.spring.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.CustomUser;
import pe.edu.upc.spring.model.UserModel;
import pe.edu.upc.spring.repository.iUserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	
	@Autowired
	private iUserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		String role = "ROLE_"+user.getType_user().getName();
		authorities.add(new SimpleGrantedAuthority(role));
		return new CustomUser(user.getUsername(), user.getPassword(), true, true, true, true, authorities, user.getId_user(), user.getType_user().getId_type_user());
	}

}
