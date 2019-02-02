package br.com.workmade.springbootsecurityouth2acl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.workmade.springbootsecurityouth2acl.entity.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {
    Perfil findByNome(String role_admin);

}
