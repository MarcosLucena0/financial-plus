package br.com.fiap.fintech.bean;

import java.util.Calendar;

public class Recebimento {

	// Atributos
	private int codigoRecebimento;
	private double valor;
	private String descricao;
	private Calendar dtRecebimento;

	// metodo construtor
	public Recebimento(int codigoRecebimento, double valor, String descricao, Calendar dtRecebimento) {
		super();
		this.codigoRecebimento = codigoRecebimento;
		this.valor = valor;
		this.descricao = descricao;
		this.dtRecebimento = dtRecebimento;
	}

	// construtor sem parametro da classe recebimento
	public Recebimento() {
		super();
	}

	public int getCodigoRecebimento() {
		return codigoRecebimento;
	}

	public void setCodigoRecebimento(int codigoRecebimento) {
		this.codigoRecebimento = codigoRecebimento;
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

	public Calendar getDtRecebimento() {
		return dtRecebimento;
	}

	public void setDtRecebimento(Calendar dtRecebimento) {
		this.dtRecebimento = dtRecebimento;
	}
	

}
