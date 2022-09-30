package br.com.entra21.backend.spring.entra21.controller;


import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.entra21.backend.spring.entra21.model.Usuario;
import br.com.entra21.backend.spring.entra21.repository.IUsuarioRepository;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioRepository usuarioRepository; //ele quem vai no banco de dados
	
	@GetMapping("/maior_que/{idade}")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> maiorQue(@PathVariable ("idade")Integer idade){
		//o PathVariable transforma o valor recebido (do GetMapping) na variavel "Integer idade" 
		
		return usuarioRepository.maiorIdade(idade);
	}
	
	@GetMapping("/cores/{corFav}")
	@ResponseStatus(HttpStatus.OK)
	public List <Usuario> corFavorita(@PathVariable ("corFav") String corFav){
		
		return usuarioRepository.corFav(corFav);
	}
	
	/*
	@GetMapping("/cores/{corFavorita}/maior_que/{idadeCor}")
	@ResponseStatus(HttpStatus.OK)
	public List <Usuario> corIdade (@PathVariable ("corFavorita") String corFavorita, @PathVariable ("idadeCor") Integer idadeCor){
		
		
		return usuarioRepository.corIdade(corFavorita, idadeCor);
	}
	*/
	
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Usuario login(@RequestBody Usuario credencial) {
		
		//não tem muito que explicar aqui, é simples
		//ele vai no banco de dados e retorna os valores correspondentes aos que foram passados
		//caso haja divergência, ele retorná branco
		//ou seja, o usuário é inexistente ou está errado, o mesmo para a senha, que pode estar errada
		return usuarioRepository.login(credencial.getEmail(), credencial.getSenha());
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody boolean deletar(@PathVariable("id") int param) {

		usuarioRepository.deleteById(param);
		return usuarioRepository.existsById(param);

	}
	
}
