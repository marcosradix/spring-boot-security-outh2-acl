package br.com.workmade.springbootsecurityouth2acl.security.config.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import br.com.workmade.springbootsecurityouth2acl.entity.enuns.PerfilEnum;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

	@Value("${jwt.oauth2.resource.id}")
	private String oauth2ResourceId;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.and().authorizeRequests()
		.antMatchers(HttpMethod.GET,"/usuario/**").hasAnyRole(PerfilEnum.ADMIN.name())
		.anyRequest().denyAll();
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(this.oauth2ResourceId);
	}
	
	
}
