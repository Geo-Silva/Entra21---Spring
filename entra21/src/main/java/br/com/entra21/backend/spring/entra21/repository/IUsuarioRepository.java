package br.com.entra21.backend.spring.entra21.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.entra21.backend.spring.entra21.model.Usuario;

@Repository
@EnableJpaRepositories
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	//adiciona vários métodos, por isso o JpaRepository
	
	//@Param para dizer que essa List é um parâmetro e recebe um valor
	//assim podemos utilizar o @Query efetivamente, trabalham juntos
	
	//o valor passado na idade é transformado no idadeParam
	@Query("From Usuario Where idade >= :idadeParam")
	List <Usuario> maiorIdade (@Param("idadeParam") Integer idade);
	//o valor passado na idade é transformado no idadeParam
	//faz que a Integer idade seja um parâmetro, que é atribuído pelo Controller
	
	//no controller seria chamado esse método que traria todos os usuários
	//percorrer a Lista procurando quem é maior de idade (por isso o >=)
	//cada item que atende o critério seria filtrado em uma nova lista
	
	//tudo isso é substituído por uma busca que traz exatamente os dados que preciso
	
	@Query("From Usuario Where email = :emailParam and senha = :senhaParam")
	Usuario login(@Param("emailParam")String email, @Param("senhaParam") String senha);
	
	@Query("From Usuario Where corFav = :corParam")
	List <Usuario> corFav (@Param("corParam") String corFav);
	
	/*
	@Query("From Usuario Where corFavorita = :coresParam and idadeCor >= :idadeCorParam")
	List <Usuario> corIdade (@Param("coresParam") String corFavorita, @Param ("idadeCorParam") Integer idadeCor);
	*/
	
}
