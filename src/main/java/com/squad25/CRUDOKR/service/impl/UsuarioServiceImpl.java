package com.squad25.CRUDOKR.service.impl;

import com.squad25.CRUDOKR.model.Usuario;
import com.squad25.CRUDOKR.service.UsuarioService;
import com.squad25.CRUDOKR.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario criar(Usuario usuario) {
        if (usuario.getId() != null) {
            Optional<Usuario> usuOptional = usuarioRepository.findById(usuario.getId());
            if (!usuOptional.isPresent()) {
                return usuarioRepository.save(usuario);
            } else {
                throw new RuntimeException("Usuário já existe");
            }
        }
        return null;
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        Usuario usu = usuarioRepository.findById(usuario.getId()).orElse(null);
        if(usu != null) {
            return usuarioRepository.save(usuario);
        }
        throw new RuntimeException("Usuário não existe");
    }

    @Override
    public void remover(Integer id) {
        Usuario usu = usuarioRepository.findById(id).orElse(null);
        if(usu != null) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não existe");
        }

    }

}
