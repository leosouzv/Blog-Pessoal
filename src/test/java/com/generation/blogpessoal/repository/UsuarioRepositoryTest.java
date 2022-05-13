package com.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogpessoal.model.Usuario;

//indica que a classe UsuarioRepositoryTest é uma classe de test para o Spring/Random port indica ao spring utilizar qualquer porta que não está sendo usada
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//Cria-se uma instância para o test, ao término do uso, a instancia é apagada (resetada). 'Ciclo de vida' do test
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;

	@BeforeAll
	public void star() {
		repository.save(new Usuario(0L, "Leozin", "leo@gmail.com", "12345abc", "https://imgur.com/wGkJQA4"));

		repository.save(new Usuario(0L, "Maiara", "maiara@gmail.com", "12345678", "https://imgur.com/Etk55mD"));

		repository.save(new Usuario(0L, "Julio", "julio@gmail.com", "abc12345", "https://imgur.com/Etk55mD"));

		repository.save(new Usuario(0L, "Neymar", "ney@gmail.com", "ney12345", "https://imgur.com/Etk55mD"));
	}

	@Test
	@DisplayName("Teste que retorna 1 usuario")
	public void retornaUmUsuario() {
		Optional<Usuario> usuario = repository.findByUsuario("leo@gmail.com");
		assertTrue(usuario.get().getUsuario().equals("leo@gmail.com"));
		/*
		 * Respostas: Sucesso - Retornou o que requisitamos Erro - Erro de sintaxe
		 * (código) Falha - Dado que esperava receber não foi recebido/foi recebido
		 * outro
		 */
	}

	@Test
	@DisplayName("Teste que retorna 1 usuario pelo nome")
	public void retornaUmUsuarioPeloNome() {
		List<Usuario> usuario = repository.findAllByNomeContainingIgnoreCase("Leozin");
		assertTrue(usuario.get(0).getUsuario().equals("Leozin"));
	}

	@AfterAll
	public void end() {
		repository.deleteAll();
	}
}
