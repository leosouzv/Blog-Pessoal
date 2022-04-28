package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

//indicando que se trata de um controller
@RestController

//URL que sera acessada a classe
@RequestMapping("/postagens")

//API aceitar requisições independente da origem
@CrossOrigin("*")
public class PostagemController {
	
	//Responsabilidade de instanciação para o Spring
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public List<Postagem> getAll() {
		return repository.findAll();
	}
}
