package com.squad25.CRUDOKR.controller;


import java.util.List;
import com.squad25.CRUDOKR.model.Usuario;
import com.squad25.CRUDOKR.service.*;
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
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }


    @PostMapping
   public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criar(usuario));
   }
   @PutMapping
   public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.atualizar(usuario));
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Usuario> atualizarPorId(@PathVariable Integer id, @RequestBody Usuario usuario) {
       if (!id.equals(usuario.getId())) {
           return ResponseEntity.badRequest().build();
       }
       Usuario usuarioAtualizado = usuarioService.atualizar(usuario);
       if (usuarioAtualizado == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(usuarioAtualizado);
   }


   @DeleteMapping("/{id}")
   public ResponseEntity<Void> remover(@PathVariable Integer id){
        usuarioService.remover(id);
        return ResponseEntity.noContent().build();
   }

}
