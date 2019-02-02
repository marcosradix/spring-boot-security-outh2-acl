package br.com.workmade.springbootsecurityouth2acl.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@ToString(of= {"nome"})
@NoArgsConstructor
@Getter 
@Setter
public class Perfil implements GrantedAuthority{

	private static final long serialVersionUID = -5861098624227133497L;

   @Id
   private String id;
   private String nome;


    @Override
    public String getAuthority() {
        return nome;
    }


	public Perfil(String name) {
		this.nome = name;
	}

}
