package br.com.entra21.backend.spring.entra21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication // <--- define as configurações adicionais para ser uma execução SpringBoot
public class Entra21Application implements CommandLineRunner {
	
	@Autowired //vai criar uma variavel do tipo jdbc já iniciada, injetada.
	private JdbcTemplate jdbc; //para conseguir conectar com o banco de dados e fazer alterações
	public static void main(String[] args) {
		SpringApplication.run(Entra21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//quando houver necessidade de implementar logicas adicionais
		//assim que o servidor é iniciado, lembre-se que existe esse evento.
		
		/* 
		String sql = "INSERT INTO programador (nome,qtd_linguagem) VALUES (?,?)";
		int result = jdbc.update(sql,"Geovani", 3 ); 
		
		Com as dependencias certas colocadas, jpa, jdbc, mysql,
		estes comandos passam a funcionar, dado a criação do @Autowired e o private JdbcTemplate
		Nesse caso, toda a vez que o servidor subir (o programa rodar), o comando será executado
		Então deixamos comentado para evitar a criação excessiva de valores no banco de dados
		Lembrar também de mexer em "application.properties" na pasta "src/main/resources"
		Adicionar lá as seguintes linhas 
		spring.datasource.url=jdbc:mysql://localhost:3306/entra21 
		spring.datasource.username=root
		spring.datasource.password=sua_senha_do_banco_de_dados
		spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
		spring.jpa.hibernate.ddl-auto=update
		spring.jpa.show-sql=true
		spring.jpa.properties.hibernate.format_sql=true
		spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57InnoDBDialect

		*/
	}

}
        