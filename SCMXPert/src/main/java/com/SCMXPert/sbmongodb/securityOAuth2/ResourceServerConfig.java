package com.SCMXPert.sbmongodb.securityOAuth2;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

import com.SCMXPert.sbmongodb.config.Constants;
import com.SCMXPert.sbmongodb.document.Role;
import com.SCMXPert.sbmongodb.repository.RoleRepository;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	RoleRepository roleRepo;
	
	public String[] getRolePermissions(String roleName) {		
		Role role = roleRepo.findByRole(roleName);
		String[] roles = role.getRolePermissions();	
		return roles;
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	 http.authorizeRequests()
	 .antMatchers(getRolePermissions(Constants.ROLE_USER)).hasAnyAuthority(Constants.ROLE_USER)
	 .antMatchers(getRolePermissions(Constants.ROLE_ADMIN)).hasAnyAuthority(Constants.ROLE_ADMIN)
	.and().exceptionHandling().accessDeniedHandler(new
		  OAuth2AccessDeniedHandler())
		 
	 ;
	}

	
	
}
