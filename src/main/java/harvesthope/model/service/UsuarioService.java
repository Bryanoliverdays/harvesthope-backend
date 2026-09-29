package com.harvesthope.model.service;

import
com.harvesthope.model.entity.Usuario;

import
com.harvesthope.model.repository.UsuarioRepository;

import
org.springframework.beans.factory.annotation.Autowired;

import 
org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class UsuarioService {
         
      @Autowired
      private UsuarioRepository
usuarioRepository;

    public Usuario salvar(Usuario usuario)
 {
        return 
    usuarioRepository.save(usuario);
   }  

   public List<Usuario> listar() {
            return
    usuarioRepository.findAll();
   }
 
   public Opitional<Usuario>
buscarporId(Long id) {
        return
usuarioRepository.findByid(id);
  }

  public Usuario atualizar(Usuario usuario) {
        return
    usuarioRepository.save(usuario);
  }
  
  public void excluir(Long id) {
        usuarioRepository.deleteById(id);
  }
}