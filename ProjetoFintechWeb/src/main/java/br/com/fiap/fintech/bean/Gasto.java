package br.com.fiap.fintech.bean;

import java.util.Calendar;

public class Gasto {

	// Atributos
	private int codigoGasto;
	private double valor;
	private String descricao;
	private Calendar dtGasto;
	private String categoria;
	
	

	public Gasto(int codigoGasto, double valor, String descricao, Calendar dtGasto, String categoria) {
		super();
		this.codigoGasto = codigoGasto;
		this.valor = valor;
		this.descricao = descricao;
		this.dtGasto = dtGasto;
		this.categoria = categoria;
	}
	
	

	public Gasto() {
		super();
	}



	public int getCodigoGasto() {
		return codigoGasto;
	}

	public void setCodigoGasto(int codigoGasto) {
		this.codigoGasto = codigoGasto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDtGasto() {
		return dtGasto;
	}

	public void setDtGasto(Calendar dtGasto) {
		this.dtGasto = dtGasto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
