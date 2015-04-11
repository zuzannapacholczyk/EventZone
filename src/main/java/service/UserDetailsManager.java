package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsManager")
public class UserDetailsManager implements UserDetailsService {

	@Autowired
	private UserManager userManager;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	
		model.User user = userManager.findUserByLogin(username);

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		List<GrantedAuthority> authorities  = new ArrayList<GrantedAuthority>(Result);
		return buildUserForAuthentication(user, authorities);
		
	}

	// Converts model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(model.User user, List<GrantedAuthority> authorities) {
		return new User(user.getLogin(), user.getPassword(), true, true, true, true, authorities);
	}

}
