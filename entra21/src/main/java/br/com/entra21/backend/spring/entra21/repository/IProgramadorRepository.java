package br.com.entra21.backend.spring.entra21.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entra21.backend.spring.entra21.model.Programador;

public interface IProgramadorRepository extends JpaRepository<Programador, Integer> {
	//O que está acontencendo é:
	//Uma entidade no código que faz as coisas que o JPA faz, com qual tipo de dado será trabalhado
	//Nesse caso, o Programador e o Integer. Sendo o Integer o valor da ID
	//Já o Programador é uma classe, então ele vai lá e executa a classe
	//Dessa forma, é dado total controle para o JPA
	//essa Interface é quem controla o CRUD, a criação e resposta de informações para as requisções
	//precisamos criar ela para a chamar no controller e efetuar o CRUD
	
}
