/**
 * 
 */
package br.com.lima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lima.model.Convidado;
import br.com.lima.repository.ConvidadoRepository;

/**
 * @author user
 *
 */
@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository convidadoDAO;

	public Iterable<Convidado> getTodos() {
		return convidadoDAO.findAll();
	}

	public void salvar(Convidado convidado) {
		convidadoDAO.save(convidado);
	}
	
	

}
