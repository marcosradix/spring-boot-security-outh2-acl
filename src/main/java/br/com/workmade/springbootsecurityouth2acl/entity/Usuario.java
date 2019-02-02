package br.com.workmade.springbootsecurityouth2acl.entity;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Document
public class Usuario {

    @Id
    private String id;
    private String nome;
    private List<Perfil> perfis;
    private int idade;
    private String email;
    private String senha;

    public Usuario(Usuario usuario) {
    	this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.perfis = usuario.getPerfis();
    }

	public Usuario(String nome, List<Perfil> perfisUsuario, String email, String senha) {
		this.nome = nome;
		this.perfis = perfisUsuario;
		this.email = email;
		this.senha = senha;
		
	}

    

}
