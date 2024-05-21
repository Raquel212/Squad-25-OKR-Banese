package com.squad25.CRUDOKR.repository;

import com.squad25.CRUDOKR.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
}
