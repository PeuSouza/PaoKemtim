package com.devpaula.PaoKemtim.Repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.devpaula.model.Entities.Forno;
import com.devpaula.model.Entities.Pao;

public class FornoRepositorio implements GenericRepository<Forno, Integer> {
	 //singleton lazy
	// Inicializa a instancia nula 
	private static FornoRepositorio instance = null;
		
	//construtor protegido pra poder  ser instanciada fora da classe
	protected FornoRepositorio() {
	}
		
	//verifica se a instancia é nula . Se for o objeto é criado.
	public static FornoRepositorio getInstance() {
		if (instance == null) {
			instance = new FornoRepositorio();
			}
			return instance;
	}
	public void create (Forno f) {
		String sql= "insert into Forno(Inicial, Saida, Pao),values(?,?,?)";
		
	try {
			
			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setObject(1, f.getInicial());
			pstm.setObject(2, f.getSaida());
			pstm.setInt(3, f.getPao().getCodigo());
			
			pstm.execute();
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Forno read (Integer codigo) {
		String sql = "select * from forno as f join pao as p on (f.pao_cod = p.codigo) where f.codigo = ?";
		try {
			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			
			pstm.setInt(1, codigo);
			
			pstm.executeQuery();
			
			ResultSet result = pstm.getResultSet();
			
			Forno f = null;
			
			if (result.next()) {
				
				f = new Forno();
				f.setCodigo(codigo);
				f.setInicial(result.getObject("Inicial",LocalDateTime.class));
				f.setSaida(result.getObject("Saida",LocalDateTime.class));
				
				Pao p = new Pao();
				p.setCodigo(result.getInt("p.codigo"));
				p.setTipo(result.getString("tipo"));
				p.setDescricao(result.getString("descricao"));
				p.setTempodeForno(result.getLong("tempodeForno"));
				f.setPao(p);
			}
		
			return f;
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void delete(Integer codigo) {
		// TODO Auto-generated method stub
		
		String sql = "delete from forno where codigo = ?";
		
		try {
			
			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setInt(1, codigo);
			
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Forno> readAll() {
		// TODO Auto-generated method stub
		
		String sql = "select * from forno as f join pao as p on (f.pao_cod = p.codigo)";
		List<Forno> fornadas = new ArrayList<>();
		try {
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.executeQuery();
		ResultSet result = pstm.getResultSet();
		
		while (result.next()) {
			Forno f = new Forno();
			f.setCodigo(result.getInt("f.codigo"));
			f.setInicial(result.getObject("Inicial", LocalDateTime.class));
			f.setSaida(result.getObject("saida", LocalDateTime.class));
			
			Pao p = new Pao();
			f.setPao(p);
			p.setCodigo(result.getInt("p.codigo"));
			p.setTipo(result.getString("tipo"));
			p.setDescricao(result.getString("descricao"));
			p.setTempodeForno(result.getLong("tempodeForno"));
			fornadas.add(f);
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fornadas;
	}
		
	public void update(Forno f) {
		
		String sql = "update forno set Inicial=?, saida=?, pao_cod=? where codigo=?";
		try {
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setObject(1, f.getInicial());
		pstm.setObject(2, f.getSaida());
		pstm.setInt(3, f.getPao().getCodigo());
		pstm.setInt(4, f.getCodigo());
		pstm.executeUpdate();
   
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	// leia o ultimo 
	
	  @Override
	  public Forno readLast (String codigoPao) throws SQLException {
	    String query = "SELECT * FROM forno JOIN Pao ON (forno.codigoPao = codigoPao.codigo)"
	        + " WHERE id = (SELECT MAX(id) FROM forno WHERE codigoPao = ?)";
	    PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(query);
	    pstm.setString(1, codigoPao);
	    ResultSet result = pstm.executeQuery();

	    Forno forno = null;
	    if (result.next()) {
	      Pao pao = new Pao();
	      pao.setTipo(result.getString("tipo"));
	      pao.setTempodeForno(result.getLong("tempodeForno"));

	      forno = new Forno();
	      forno.setCodigo(result.getInt("codigo"));
	      forno.setPao(pao);
	    }

	    return forno;
	  }


}
	
    

