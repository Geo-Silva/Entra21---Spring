package br.com.entra21.backend.spring.entra21.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id							
	@GeneratedValue(strategy=GenerationType.IDENTITY) //define como AutoIncrement, para bater com o Banco de dados
	private Integer id;
	private String email;
	private String senha;
	private String corFav;
	private Integer idade;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String email, String senha, String corFav, Integer idade) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.corFav = corFav;
		this.idade = idade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public String getCorFav() {
		return corFav;
	}

	public void setCorFav(String corFav) {
		this.corFav = corFav;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
}
