package br.com.workmade.springbootsecurityouth2acl.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.workmade.springbootsecurityouth2acl.entity.Perfil;
import br.com.workmade.springbootsecurityouth2acl.entity.Usuario;
import br.com.workmade.springbootsecurityouth2acl.entity.enuns.PerfilEnum;
import br.com.workmade.springbootsecurityouth2acl.repository.PerfilRepository;
import br.com.workmade.springbootsecurityouth2acl.repository.UsuarioRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<Perfil> perfis = this.perfilRepository.findAll();
		System.out.println("saida "+perfis );
		if(perfis.isEmpty()) {
			this.perfilRepository.save(new Perfil(PerfilEnum.ADMIN.name()));
			Perfil perfil = perfilRepository.findByNome(PerfilEnum.ADMIN.name());
			List<Perfil> perfisUsuario = new ArrayList<>();
			perfisUsuario.add(perfil);
			
			this.usuarioRepository.save(new Usuario("Marcos Ferreira", perfisUsuario, "admin","123"));
		}
		
	}

}
