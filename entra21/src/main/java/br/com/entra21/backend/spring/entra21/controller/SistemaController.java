package br.com.entra21.backend.spring.entra21.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController //para dizer que essa classe é um controller
@CrossOrigin(origins="*") //para aceitar todas as origens
@RequestMapping("/sistema") //url + /sistema
public class SistemaController {
	
	@GetMapping() //mapeamento, requisições GET podem chamar esse método
	@ResponseStatus(HttpStatus.OK) //status da resposta ao frontend, se deu tudo certo ele retorna "OK"
	public String testar() {
		
		return "Estou on";
	}
	@GetMapping("merendar")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public boolean merendar() {
		
		return false;
	}
	
	
}
