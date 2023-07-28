package com.devpaula.PaoKemtim.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devpaula.PaoKemtim.Repositories.PaoRepositorio;
import com.devpaula.PaoKemtim.Repositories.RepositoryFacade;
import com.devpaula.model.Entities.Pao;



@CrossOrigin("*")
@RestController
@RequestMapping("/pao")
public class PaoController {

	@PostMapping
	public void create(@RequestBody Pao pao) {
		
		try {
			RepositoryFacade.getCurrentInstance().create(pao);
		} catch (SQLException e) {
		e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Não foi possível cadastrar o paozinho!");
		}
		
	}
	
//	@PutMapping
//	public  String update(@RequestBody Pao pao) {
//		try {
//	        RepositoryFacade.getCurrentInstance().update(pao);
//		    return "Cardápio de pães atualizados!";
//		} catch (SQLException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
//					"Não foi possível atualizar a lista de pães do cardápio!");
//		}
//		
//	}
//	
	@GetMapping("/{codigo}")
	public Pao read(@PathVariable("codigo") int codigo) {
		try {
		     Pao pao = RepositoryFacade.getCurrentInstance().readPao(codigo); 
		     return pao;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Não foi possivel fazer a leitura dos pães");
		}
		
	}
	
	@DeleteMapping("/{codigo}")
	public String delete(@PathVariable("codigo") int codigo) {
	try {
		RepositoryFacade.getCurrentInstance().deletePao(codigo);
		return "Paozinho deletado do cardápio!";
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
				"Não foi possível deletar o paozinho!");
	  }
	
	}
	
	@GetMapping("/pao")
	public List<Pao> readAll() {
		try {
			return RepositoryFacade.getCurrentInstance().readAllPao();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro ao ler os pães.");
		}
		
     }
	
}