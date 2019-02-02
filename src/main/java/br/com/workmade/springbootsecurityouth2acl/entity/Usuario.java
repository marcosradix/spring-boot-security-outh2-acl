package br.com.workmade.springbootsecurityouth2acl.entity;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor(force=true)
@RequiredArgsConstructor
@Document
public class Usuario {

    @Id
    private String id;
    private final String nome;
    private final List<Perfil> perfis;
    private int idade;
    private final String email;
    private final String senha;

    public Usuario(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.perfis = usuario.getPerfis();
    }

    

}
