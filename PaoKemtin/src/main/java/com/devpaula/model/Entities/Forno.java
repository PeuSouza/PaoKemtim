package com.devpaula.model.Entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Forno {
	private int codigo;
	private LocalDateTime Inicial;
	private LocalDateTime Saida;
	private Pao pao;
	
	/*é possível utilizar a classe LocalDateTime disponível a partir do Java 8, por meio do seu
	método estático now(), que coleta a informação de data atual de acordo com as informações do relógio 
	do sistema operacional*/
	public Forno() {
		this.Inicial= LocalDateTime.now();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public LocalDateTime getInicial() {
		return Inicial;
	}
	public void setInicial(LocalDateTime localDateTime) {
		Inicial = localDateTime;
	}
	
	public Pao getPao() {
		return pao;
	}
	public void setPao(Pao pao) {
		this.pao = pao;
	}
	
	public LocalDateTime getSaida() {
		return Saida;
	}

	public void setSaida(LocalDateTime localDateTime) {
		this.Saida = localDateTime;
	}
	
	public void atualizaSaida() {
		if (pao != null) {
			this.Saida = this.Inicial.plusMinutes(pao.getTempodeForno());
		}
	}

	
	//utilizarei o método Objects.hash() para calcular o hash code com base no atributo codigo do objeto Forno.
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	// verificar as fornadas
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Forno other = (Forno) obj;
		return codigo == other.codigo;
	}


	public LocalDateTime getTempoSaida() {
			/*O método plusMinutes() da classe LocalDateTime é usado para retornar uma cópia 
			 dessa data e hora com os minutos especificados adicionados.Neste caso usaremos a hora
			 mais o tempo para o pão ficar pronto*/
			return this.Inicial.plusMinutes(pao.getTempodeForno());
	}
}
	