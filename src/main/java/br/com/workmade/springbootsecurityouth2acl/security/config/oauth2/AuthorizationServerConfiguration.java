package br.com.workmade.springbootsecurityouth2acl.security.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import br.com.workmade.springbootsecurityouth2acl.security.service.MyUserDetailService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private TokenStore tokenStore = new InMemoryTokenStore();
	@Autowired
	private MyUserDetailService myUserDetailService;

	@Autowired
	@Qualifier(value = BeanIds.AUTHENTICATION_MANAGER) // usando value
	private AuthenticationManager authenticationManager;

	@Value("${jwt.oauth2.secret}")
	private String oauth2Secret;

	@Value("${jwt.oauth2.client}")
	private String oauth2Client;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
				.userDetailsService(myUserDetailService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(this.oauth2Client)
				.authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("bar", "read", "write")
				.refreshTokenValiditySeconds(20000).accessTokenValiditySeconds(20000).secret(this.oauth2Secret);

	}


	@Bean
	@Primary
	public DefaultTokenServices defaultTokenService() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setSupportRefreshToken(true);
		defaultTokenServices.setTokenStore(tokenStore);
		return defaultTokenServices;

	}

}
