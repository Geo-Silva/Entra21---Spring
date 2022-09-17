package br.com.entra21.backend.spring.entra21.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name="programador") //dizendo qual table para facilitar a consulta no Sql
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Programador extends MaturidadeNivel3Richardson{

	@Id //identidade da tabela sql
	@GeneratedValue(strategy=GenerationType.IDENTITY) //ela é utilizada quando o JPA entra em ação
	//se for passado um valor sem um ID, mas tem outros valores, ele irá adicionar um ID e colocar na tabela
	//mas caso já seja passado um ID já existente, ele irá atualizar os valores correpondentes
	private Integer id;
	private String nome;
	private Integer qtd_linguagem;
	
	public Programador(Integer id, String nome, Integer qtd_linguagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtd_linguagem = qtd_linguagem;
	}
	
	public Programador() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtd_linguagem() {
		return qtd_linguagem;
	}

	public void setQtd_linguagem(Integer qtd_linguagem) {
		this.qtd_linguagem = qtd_linguagem;
	}
	
	
	
}
