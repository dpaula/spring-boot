/**
 * 
 */
package br.com.lima.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author user
 *
 */
@SpringBootApplication
@Controller
public class Configuracao {

	@RequestMapping("/")
	@ResponseBody
	public String ola() {
		return "Ola maldito";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(Configuracao.class, args);

	}

}
