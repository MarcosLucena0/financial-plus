package br.com.fiap.fintech.bean;

import java.util.Calendar;

public class ObjFinanceiro {
	
	private int codigoObjFinanceiro;
	private String nomeObjFinanceiro;
	private double valor;
	private String descricao;
	private Calendar dataObjFinanceiro;
	
	public ObjFinanceiro(int codigoObjFinanceiro, String nomeObjFinanceiro, double valor, String descricao,
			Calendar dataObjFinanceiro) {
		super();
		this.codigoObjFinanceiro = codigoObjFinanceiro;
		this.nomeObjFinanceiro = nomeObjFinanceiro;
		this.valor = valor;
		this.descricao = descricao;
		this.dataObjFinanceiro = dataObjFinanceiro;
	}

	public ObjFinanceiro() {
		super();
	}

	public int getCodigoObjFinanceiro() {
		return codigoObjFinanceiro;
	}

	public void setCodigoObjFinanceiro(int codigoObjFinanceiro) {
		this.codigoObjFinanceiro = codigoObjFinanceiro;
	}

	public String getNomeObjFinanceiro() {
		return nomeObjFinanceiro;
	}

	public void setNomeObjFinanceiro(String nomeObjFinanceiro) {
		this.nomeObjFinanceiro = nomeObjFinanceiro;
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

	public Calendar getDataObjFinanceiro() {
		return dataObjFinanceiro;
	}

	public void setDataObjFinanceiro(Calendar dataObjFinanceiro) {
		this.dataObjFinanceiro = dataObjFinanceiro;
	}

	
	
	
	
}
