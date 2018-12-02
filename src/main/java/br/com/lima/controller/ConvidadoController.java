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
import br.com.lima.repository.ConvidadoRepository;

/**
 * @author user
 *
 */
@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoRepository convidadoDAO;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {

		Iterable<Convidado> convidados = convidadoDAO.findAll();

		model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {

		Convidado convidado = new Convidado(nome, email, telefone);
		
		convidadoDAO.save(convidado);
		
		Iterable<Convidado> convidados = convidadoDAO.findAll();
		
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}
}
