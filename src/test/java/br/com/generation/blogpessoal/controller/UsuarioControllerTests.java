package br.com.generation.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.generation.blogpessoal.model.Usuario;
import br.com.generation.blogpessoal.repository.UsuarioRepository;
import br.com.generation.blogpessoal.service.UsuarioService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start() {
	usuarioRepository.deleteAll();

	usuarioService.cadastrarUsuario(new Usuario(null, "root", "root@roo.com", "rootroot", "-"));
    }

    @Test
    @DisplayName("Cadastrar Usuario")
    public void deveCriaUmUsuario() {
	HttpEntity<Usuario> corpoRequisicaoHttp = new HttpEntity<Usuario>(
		new Usuario(null, "Vini Cris", "vini@meuemial.com", "12345678", "-"));

	ResponseEntity<Usuario> corpoResposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST,
		corpoRequisicaoHttp, Usuario.class);

	assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
    }

    @Test
    @DisplayName("Não deve permitir duplicaçao do Usuário")
    public void naoDeveDuplicarUsuario() {
	usuarioService
		.cadastrarUsuario(new Usuario(null, "Maria da Silva", "maria_silva@email.com.br", "13465278", "-"));

	HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(
		new Usuario(null, "Maria da Silva", "maria_silva@email.com.br", "13465278", "-"));

	ResponseEntity<Usuario> corpoResposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST,
		corpoRequisicao, Usuario.class);

	assertEquals(HttpStatus.BAD_REQUEST, corpoResposta.getStatusCode());
    }

    @Test
    @DisplayName("Atualizar um Usuario")
    public void deveAtualizarUmUsuario() {
	Optional<Usuario> usuarioCadastrado = usuarioService.cadastrarUsuario(
		new Usuario(null, "Juliana Andrews", "juliana_andrews@email.com.br", "juliana123", "-"));

	Usuario usuarioUpdate = new Usuario(usuarioCadastrado.get().getId(), "Juliana Andrews Ramos",
		"juliana_ramos@email.com.br", "juliana123", "-");

	HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(usuarioUpdate);

	ResponseEntity<Usuario> corpoResposta = testRestTemplate
		.withBasicAuth("root@root.com", "rootroot")
		.exchange("/usuarios/atualizar", HttpMethod.PUT, corpoRequisicao, Usuario.class);

	assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());
    }

    @Test
    @DisplayName("Listar todos os Usuarios")
    public void deveMostrarTodosUsuarios() {
	usuarioService.cadastrarUsuario(
		new Usuario(null, "Sabrina Sanches", "sabrina_sanches@email.com.br", "sabrina123", "-"));
	
	usuarioService.cadastrarUsuario(
		new Usuario(null, "Ricardo Marques", "ricardo_marques@email.com.br", "ricardo123", "-"));
	
	ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("root@root.com", "rootroot")
		.exchange("/usuarios/all", HttpMethod.GET, null, String.class);
	
	assertEquals(HttpStatus.OK, resposta.getStatusCode());
    }
}
