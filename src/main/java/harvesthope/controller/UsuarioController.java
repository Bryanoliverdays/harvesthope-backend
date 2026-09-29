package com.harvesthope.controller;

import 
com.harvesthope.model.entity.Usuario;

import 
com.harvesthope.model.service.UsuarioService;

import
org.springframework.beans.factory.annotation.Autowired;

import
org.springframework.http.ResponseEntity;

import
org.springframework.web.bind.annotation.*;

import java.util.List;

@Restcontroller
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
            return
    usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario>
buscarporId(@PathVariable Long id) {
    return
usuarioService.buscarporId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build();)
}
    @PutMapping("{id}")
    public ResponseEntity<Usuario>
atualizar(
    @PathVariable Long id,
    @RequestBody Usuario usuario)
{

        if 
(usuarioService.buscarPorId(id).isEmpty())
{
        return
ResponseEntity.notFound().build();
}

    usuario.setId(id);
    return
ResponseEntity.ok(usuarioService.atualizar(usuario));
}

    @DeleteMapping("{id}")
    public ResponseEntity<Void>
excluir(@PathVariable Long id) {

        if
(usuarioService.buscarPorId(id).isEmpty())
{
        return
ResponseEntity.notFound().build();
}




            usuarioService.excluir(id);
            return
ResponseEntity.noContent().build();
    }
}