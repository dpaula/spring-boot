/**
 * 
 */
package br.com.lima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lima.model.Convidado;
import br.com.lima.repository.ConvidadoRepository;

/**
 * @author user
 *
 */
@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		
		System.out.println("FOOOOOOOOOOOIIIIIIIIIIII");
		
		Iterable<Convidado> convidados = convidadoRepository.findAll();
		
		model.addAttribute("convidados", convidados);
		
		return "listaconvidados";
	}
}
