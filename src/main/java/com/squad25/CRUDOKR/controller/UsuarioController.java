package com.squad25.CRUDOKR.controller;


import java.util.List;
import com.squad25.CRUDOKR.model.Usuario;
import com.squad25.CRUDOKR.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
   public ResponseEntity<List<Usuario>> buscarTodos(){
       return ResponseEntity.ok(usuarioService.buscarTodos());
   }

    @PostMapping
   public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criar(usuario));
   }
   @PutMapping
   public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.atualizar(usuario));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity remover(@PathVariable Integer id){
        usuarioService.remover(id);
        return ResponseEntity.noContent().build();
   }

}
