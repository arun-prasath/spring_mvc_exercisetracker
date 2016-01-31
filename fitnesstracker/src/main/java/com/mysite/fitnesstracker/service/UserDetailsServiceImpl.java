package com.mysite.fitnesstracker.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysite.fitnesstracker.model.MyUserDetails;
import com.mysite.fitnesstracker.model.User;
import com.mysite.fitnesstracker.model.UserRole;
import com.mysite.fitnesstracker.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		User user = userRepository.findOne(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username");
		}
		
		return buildUserDetailsFromEntity(user);
	}

	private UserDetails buildUserDetailsFromEntity(User user) {
		String username = user.getUsername();
	    String password = user.getPassword();
	    boolean enabled = user.isActive();
	    boolean accountNonExpired = user.isActive();
	    boolean credentialsNonExpired = user.isActive();
	    boolean accountNonLocked = user.isActive();
	    Set<GrantedAuthority> userAuthorities = buildUserAuthority(user.getUserRoles());
	    
		return new MyUserDetails(username, password, enabled, 
				accountNonExpired, accountNonLocked, credentialsNonExpired, userAuthorities);
	}

	private Set<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		
		for(UserRole userRole : userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		return grantedAuthorities;
	}

}
