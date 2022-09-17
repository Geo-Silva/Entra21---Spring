package br.com.entra21.backend.spring.entra21;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

	//Essa classe tem o objetivo de remover as restrições cors de segurança que exigem 
	//origens e métodos declaradamente permitidos para que execuções externas possam acionar os controllers
	
	public void addCorsMapping(CorsRegistry registry) {
		//implementando a liberação cors
		registry.addMapping("/**")
		.allowedOrigins("*") //origens permitidas, nesse caso, todas
		        .allowedMethods("GET","POST","PUT", "DELETE");  //requisões permitidas
		
	}
	
}
