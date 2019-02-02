package br.com.workmade.springbootsecurityouth2acl.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.workmade.springbootsecurityouth2acl.entity.Usuario;
import br.com.workmade.springbootsecurityouth2acl.repository.UsuarioRepository;
import br.com.workmade.springbootsecurityouth2acl.security.config.MyUserDetails;

@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário ou senha inválidos");
		}
		return new MyUserDetails(usuario);
	}

}
