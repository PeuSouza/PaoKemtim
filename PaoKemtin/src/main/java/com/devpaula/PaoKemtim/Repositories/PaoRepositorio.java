package com.devpaula.PaoKemtim.Repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.devpaula.model.Entities.Pao;

public class PaoRepositorio implements GenericRepository <Pao, Integer>{

	 //singleton lazy
	// Inicializa a instancia nula 
	private static PaoRepositorio instance = null;
	
	//construtor protegida pra ela ser instanciada fora da classe
	protected PaoRepositorio() {
	}
	
	//verifica se a instancia é nula . Se for o objeto é criado.
	public static PaoRepositorio getInstance() {
		if (instance == null) {
			instance = new PaoRepositorio();
		}
		return instance;
	}
	
	
	public void create (Pao p) {
		String sql= "insert into Pao(tipo, descricao, tempodeForno),values(?,?,?)";
          
		try {
			
			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setString(1, p.getTipo());
			pstm.setString(2, p.getDescricao());
			pstm.setLong(3, p.getTempodeForno());
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		public void update (Pao p) {
			
			String sql = "update cliente set tipo=?, descricao=?, tempodeForno=? where codigo=?";
			
			try {
				
				PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			
				pstm.setString(1, p.getTipo());
				pstm.setString(2, p.getDescricao());
				pstm.setLong(3,p.getTempodeForno());
				pstm.setInt(4, p.getCodigo());
				
				pstm.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public Pao read (Integer key) {
			// TODO Auto-generated method stub
			
			String sql = "select * from pao where codigo=?";
			
	try {
				PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			
				pstm.setInt(1,key);
				
				ResultSet  result = pstm.executeQuery();
				
				Pao p = null;
				
				if (result.next()) {
					p = new Pao();
					p.setCodigo(key);
					p.setTipo(result.getString("nome"));
					p.setDescricao(result.getString("descricao"));
					p.setTempodeForno(result.getLong("TempodeForno"));
				}
				return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

		public void delete(Integer key) {
			// TODO Auto-generated method stub
			
			String sql = "delete from pao where codigo = ?";
			
			try {
				
				PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			
				pstm.setInt(1, key);
				
				pstm.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		public List<Pao> readAll() {
			// TODO Auto-generated method stub
			
			String sql = "select * from pao";
			
			List<Pao> listPaes = new ArrayList<>();
			
			try {
				
				PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
				
				ResultSet  result = pstm.executeQuery();
				
				Pao p = null;
				
				while(result.next()) {
					p = new Pao();
					p.setCodigo(result.getInt("codigo"));
					p.setTipo(result.getString("tipo"));
					p.setDescricao(result.getString("descricao"));
					p.setTempodeForno(result.getLong("tempodeForno"));
					
					listPaes.add(p);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listPaes;
		}



    
}
	
	

