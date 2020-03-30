package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {
	
	public List<Corso> getCorsiByPeriodo(int periodo){
		
		List<Corso> corsi = new LinkedList<Corso>();
		
		String sql = "SELECT * FROM corso WHERE pd = ?";

		try {
			Connection connessione = ConnectDB.getConnection();
			PreparedStatement st = connessione.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("nome"), rs.getInt("pd"), rs.getString("codins"), rs.getInt("crediti"));
				corsi.add(c);
			}
			st.close();
			connessione.close();
			
		}catch(SQLException e){
			throw new RuntimeException();
		}
		return corsi;
	}
	
	public Map<Corso, Integer> getIscrittiByPeriodo(int periodo){
		
		Map<Corso, Integer> corsi = new HashMap<Corso, Integer>();
		
		String sql = "SELECT c.codins, c.nome, c.crediti, c.pd, COUNT(*) AS tot FROM corso AS c, iscrizione i WHERE c.codins = i.codins AND c.pd = ?"
				+ " GROUP BY c.codins, c.nome, c.crediti, c.pd ";

		try {
			Connection connessione = ConnectDB.getConnection();
			PreparedStatement st = connessione.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("nome"), rs.getInt("pd"), rs.getString("codins"), rs.getInt("crediti"));
				Integer n = rs.getInt("tot");
				corsi.put(c,n);
			}
			st.close();
			connessione.close();
			
		}catch(SQLException e){
			throw new RuntimeException();
		}
		return corsi;
	}

}
