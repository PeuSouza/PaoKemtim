package com.devpaula.PaoKemtim.Repositories;

import java.util.List;

import com.devpaula.model.Entities.Pao;
import com.devpaula.model.Entities.Forno;


public class RepositoryFacade {

	private static RepositoryFacade instance = new RepositoryFacade();
	
	private GenericRepository< Pao, Integer> PaoRep =null;
	private GenericRepository <Forno, Integer> FornoRep = null;
	
 private RepositoryFacade() {
		
		this.PaoRep = new PaoRepositorio();
		this.FornoRep = new FornoRepositorio();
}
 public static RepositoryFacade getCurrentInstance() {
	return instance;
}

 
 //create
 public void create (Pao pao) {
	 this.PaoRep.create(pao);
 }
 
 public void create (Forno forno) {
	 this.FornoRep.create(forno);
 }
 
 //update
 public void update (Pao pao) {
	 this.PaoRep.update(pao);
 }
 
 public void update (Forno forno) {
	 this.FornoRep.update(forno);
 }
 
 //read
	
	public Pao readPao(int codigo) {
		return this.PaoRep.read(codigo);
	}
 
	
	public Forno readForno(int codigo) {
		return this.FornoRep.read(codigo);
	}
	
	
//delete
	public void deletePao(int codigo) {
		this.PaoRep.delete(codigo);
	}
	
	public void deleteForno(int codigo) {
		this.FornoRep.delete(codigo);
	}
	
//lertudo
	
	public List<Pao> readAllPao(){
		return this.PaoRep.readAll();
	}
	public List<Forno> readAllForno(){
		return this.FornoRep.readAll();
	}


}