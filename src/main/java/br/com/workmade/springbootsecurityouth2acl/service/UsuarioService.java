package br.com.workmade.springbootsecurityouth2acl.service;



import java.util.List;
import java.util.Optional;

import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.workmade.springbootsecurityouth2acl.entity.Usuario;
import br.com.workmade.springbootsecurityouth2acl.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuario() {
        return usuarioRepository.findAll();
    }

    public Page<Usuario> listaPaginada(int count, int page) {
        Pageable pages = PageRequest.of(page, count);
        return usuarioRepository.findAll(pages);
    }

    public List<Usuario> buscaPorNome(String nome) {
        return usuarioRepository.findByNomeLikeIgnoreCase(nome);
    }

    public Usuario salvarUsuario(Usuario usuarioAdd) {
        return usuarioRepository.save(usuarioAdd);
    }

    public void deleteUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario getById(String id) {
    	Optional<Usuario> usuario = usuarioRepository.findById(id);
    	usuario.orElseThrow(()-> new OBJECT_NOT_EXIST("Objeto não encontrado"));
        return null;
    }

}
