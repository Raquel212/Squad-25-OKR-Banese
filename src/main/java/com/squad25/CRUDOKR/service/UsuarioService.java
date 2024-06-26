package com.squad25.CRUDOKR.service;

import java.util.List;
import com.squad25.CRUDOKR.model.Usuario;

public interface UsuarioService {
    List<Usuario> buscarTodos();
    Usuario criar(Usuario usuario);
    Usuario atualizar(Usuario usuario);
    void remover(Integer id);
	Usuario buscarPorId(Integer id);
}
