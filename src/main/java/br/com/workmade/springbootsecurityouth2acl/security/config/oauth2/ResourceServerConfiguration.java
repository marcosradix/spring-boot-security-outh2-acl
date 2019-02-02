package br.com.workmade.springbootsecurityouth2acl.security.config.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import br.com.workmade.springbootsecurityouth2acl.entity.enuns.PerfilEnum;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.and().authorizeRequests()
		.antMatchers("/usuario/**").hasAnyRole(PerfilEnum.ADMIN.name())
		.anyRequest().denyAll();
	}
	
	
	
}
