package com.generation.blogpessoal.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogpessoal.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//Quando não se sabe qual tipo de resposta pode ter ao buscar na requisição e tem mais de uma possível
	public Optional<Usuario> findByUsuario(String usuario);
	
}
