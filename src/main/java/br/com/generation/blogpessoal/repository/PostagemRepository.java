package br.com.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.blogpessoal.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

   
    
}
