package com.madeeasy.security.token;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class CustomAuthenticationToken implements Authentication {
	private static final long serialVersionUID = 1L;

	private Object authentication;
	private Object key;

	public CustomAuthenticationToken(Object authentication, Object key) {
		this.authentication = authentication;
		this.key = key;
	}

	public Object getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Object authentication) {
		this.authentication = authentication;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getDetails() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		return (boolean) authentication;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

	}

	@Override
	public String getName() {
		return null;
	}
}