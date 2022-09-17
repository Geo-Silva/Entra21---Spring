package br.com.entra21.backend.spring.entra21.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.entra21.backend.spring.entra21.model.ItemNivel3;
import br.com.entra21.backend.spring.entra21.model.Programador;
import br.com.entra21.backend.spring.entra21.repository.IProgramadorRepository;

@RestController // dizendo que essa classe é um controller
@CrossOrigin(origins = "*")
@RequestMapping("/programadores")
public class ProgramadorController {

	@Autowired // ele injeta no construtor o começo dele. NomeDaClasse nome = new
				// NomeDaClasse()
	private IProgramadorRepository programadorRepository;

	// daqui para baixo é um Controller
	@GetMapping() // Definindo o controller para um GET
	@ResponseStatus(HttpStatus.OK) // resposta do site em caso de sucesso, nesse caso, OK
	public List<Programador> listar() {

		List<Programador> response = programadorRepository.findAll(); // vai no banco procurar por todos os registros de programador
		response.forEach(programador ->{	//percorrer o array, função lambda
			setMaturidadeNivel3(programador);
			//antes de devolver pro usuario, defino as informações de nivel de maturidade
		});
		return response;
		
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Programador> buscar(@PathVariable("id") int param) { // para transformar o valor de ID recebido em de
																		// fato uma ID

		List<Programador> response = programadorRepository.findById(param).stream().toList();
		return response; // retornar o valor encontrado
		// basicamente ele irá procurar pela ID recebida
		// Resumindo o código de certa forma:
		// .findById(variavelQueRecebeuOValorDeId).passarOValorParaUmaLista
	}

	@PostMapping() // Esse aqui é um POST, não um GET
	@ResponseStatus(HttpStatus.CREATED) // Como é um POST, será um CREATED como resposta, que significa que foi criado
	public @ResponseBody Programador adicionar(@RequestBody Programador novoProgramador) {
		// @ResponseBody significa para trazer o resultado no body, no corpo da
		// requisição
		// @RequestBody significa que a requisção será feita pelo body (no postman por
		// exemplo)
		return programadorRepository.save(novoProgramador); // vai no banco, cria o novo programador e também retorna o
															// valor criado
	}

	@PutMapping("/{id}") // É um PUT, ele vai atualizar as informações
	@ResponseStatus(HttpStatus.OK)
	public Optional<Programador> atualizar(@PathVariable("id") int param,
			@RequestBody Programador programadorNovosDados) {

		Programador atual = programadorRepository.findById(param).get(); // vai procurar a ID e trazer os dados
		atual.setNome(programadorNovosDados.getNome()); // pegar o nome desse ID
		atual.setQtd_linguagem(programadorNovosDados.getQtd_linguagem()); // pegar a qtd de linguagens
		programadorRepository.save(atual); // salvar a alteração de valores
		return programadorRepository.findById(param); // reforçando a alteração de valores
	}

	@DeleteMapping("/{id}") // É um DELETE, deleta as informações baseado na ID recebida
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody boolean deletar(@PathVariable("id") int param) {
		// o @PathVariable significa em qual parte da URL o programa irá olhar, nesse
		// caso, o ID
		// Se o mesmo fosse "programador", ele ignoraria o ID e procuraria as
		// informações na parte de programador
		programadorRepository.deleteById(param);
		return programadorRepository.existsById(param);

	}

	private void setMaturidadeNivel3(Programador programador) {

		final String PATH = "localhost:8080/programadores";
		ArrayList<String> headers = new ArrayList<String>();
		headers.add("Accept : application/json");
		headers.add("Content-type : application/json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);

		try {

			Programador clone = mapper.readValue(mapper.writeValueAsString(programador), Programador.class);
			clone.setLinks(null);
			String nomeAtual = clone.getNome();
			clone.setNome("Nome diferente");
			String jsonUpdate = mapper.writeValueAsString(clone);
			clone.setNome(nomeAtual);
			clone.setId(null);
			String jsonCreate = mapper.writeValueAsString(clone);

			programador.setLinks(new ArrayList<>());
			programador.getLinks().add(new ItemNivel3("GET", PATH, null, null));
			programador.getLinks().add(new ItemNivel3("GET", PATH + "/" + programador.getId(), null, null));
			programador.getLinks().add(new ItemNivel3("POST", PATH, headers, jsonCreate));
			programador.getLinks().add(new ItemNivel3("PUT", PATH + "/" + programador.getId(), headers, jsonUpdate));

		} catch (JsonProcessingException e) {

			e.printStackTrace();

		}

	}

	/*
	 * Siginificado de Controller!
	 * 
	 * [21:10] Kalil J. Fakhouri (Convidado) é basicamente o que irá mapear os seus
	 * métodos e retorno de dados
	 * 
	 * [21:10] rumblycactus3 (Convidado) Ahh, entendi! Valeu!
	 * 
	 * [21:10] Kalil J. Fakhouri (Convidado) métodos q eu digo se vc quer um GET,
	 * POST, DELETE, etc
	 * 
	 * (Obrigado, Kalil :D)
	 */
}
