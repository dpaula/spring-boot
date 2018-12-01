/**
 * 
 */
package br.com.lima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author user
 *
 */
@Controller
public class ConvidadoController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
