package com.mainapp.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mainapp.entities.Role;
import com.mainapp.entities.User;

public class MyUserDetails implements UserDetails {
	
	
	private User user;
	
	public MyUserDetails(User user) {
        this.user = user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		for(Role r: roles) {
			authorities.add(new SimpleGrantedAuthority(r.getRoleType()));
		}
		
		return authorities;
	}

	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// inital config
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// inital config
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// inital config
		return true;
	}

	@Override
	public boolean isEnabled() {
		// inital config
		return true;
	}


}
