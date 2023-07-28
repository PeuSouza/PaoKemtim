package com.devpaula.model.Entities;

public class Pao {
	private int codigo;
	private String tipo;
    private String descricao;
	private long tempodeForno;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo= codigo;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public long getTempodeForno() {
		return tempodeForno;
	}
	public void setTempodeForno(Long tempodeForno) {
		this.tempodeForno = tempodeForno;
	}
	
	
}

