package br.com.entra21.backend.spring.entra21.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entra21.backend.spring.entra21.model.Personagem;

public interface IPersonagemRepository extends JpaRepository<Personagem, Integer> {

}
