package br.com.workmade.springbootsecurityouth2acl.service;


import java.util.List;
import java.util.Optional;

import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.workmade.springbootsecurityouth2acl.entity.Perfil;
import br.com.workmade.springbootsecurityouth2acl.repository.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    public List<Perfil> listaPerfil() {
        return perfilRepository.findAll();
    }

    public Page<Perfil> listaPaginada(int count, int page) {
        Pageable pages = PageRequest.of(page, count);
        return perfilRepository.findAll(pages);
    }


    public Perfil salvarPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public void deletePerfil(String id) {
        perfilRepository.deleteById(id);
    }

    public Perfil getById(String id) {
         Optional<Perfil>  perfil = perfilRepository.findById(id);
         return perfil.orElseThrow(() -> new OBJECT_NOT_EXIST("Objeto não encontrado"));
        		
    }

}
