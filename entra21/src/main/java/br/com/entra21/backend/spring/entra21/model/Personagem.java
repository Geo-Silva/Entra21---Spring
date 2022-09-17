package br.com.entra21.backend.spring.entra21.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="personagem")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personagem extends MaturidadeNivel3Richardson {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String habilidade;
	private String nome_heroi;
	private String nome_real;
	private Integer idade;
	//vale lembrar aqui que, uma boolean no MySQL fica definida como "TINYBIT"
	//Isso não é um erro, mantenha desse jeito e siga a lógica do código
	
	public Personagem() {
		super();
	}

	public Personagem(Integer id, String habilidade, String nome_heroi, String nome_real, Integer idade) {
		super();
		this.id = id;
		this.habilidade = habilidade;
		this.nome_heroi = nome_heroi;
		this.nome_real = nome_real;
		this.idade = idade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

	public String getNome_heroi() {
		return nome_heroi;
	}

	public void setNome_heroi(String nome_heroi) {
		this.nome_heroi = nome_heroi;
	}

	public String getNome_real() {
		return nome_real;
	}

	public void setNome_real(String nome_real) {
		this.nome_real = nome_real;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
}



