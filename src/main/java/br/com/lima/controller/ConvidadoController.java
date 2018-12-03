/**
 * 
 */
package br.com.lima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lima.model.Convidado;
import br.com.lima.service.ConvidadoService;
import br.lima.enviaEmail.EmailService;

/**
 * @author user
 *
 */
@Controller
public class ConvidadoController {

	@Autowired
	ConvidadoService convidadoService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {

		Iterable<Convidado> convidados = convidadoService.getTodos();

		model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {

		Convidado convidado = new Convidado(nome, email, telefone);
		
		convidadoService.salvar(convidado);
		
		EmailService emailService = new EmailService();
		emailService.enviar(nome, email);
		
		Iterable<Convidado> convidados = convidadoService.getTodos();
		
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}
}
