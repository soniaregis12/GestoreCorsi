package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	CorsoDAO dao;
	
	public Model() {
		dao = new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(int periodo){
		
		return dao.getCorsiByPeriodo(periodo);
	}
	
	public Map<Corso, Integer> getIscrittiByPeriodo(int periodo){
		
		return dao.getIscrittiByPeriodo(periodo);
	}

}
