package br.com.workmade.springbootsecurityouth2acl.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.workmade.springbootsecurityouth2acl.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    List<Usuario> findByNomeLikeIgnoreCase(String nome);

    Usuario findByEmail(String username);
}
