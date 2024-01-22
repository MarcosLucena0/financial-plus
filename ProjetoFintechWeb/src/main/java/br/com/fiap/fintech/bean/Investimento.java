package br.com.fiap.fintech.bean;

import java.util.Calendar;

public class Investimento {

	// atributos
	private int codigoInvestimento;
	private String tipoInvestimento;
	private String aplicacaoFinanceira;
	private String nomeBanco;
	private double valor;
	private Calendar dataInvestimento;
	private Calendar dataVencimento;

	public Investimento(int codigoInvestimento, String tipoInvestimento, String aplicacaoFinanceira, String nomeBanco,
			double valor, Calendar dataInvestimento, Calendar dataVencimento) {
		super();
		this.codigoInvestimento = codigoInvestimento;
		this.tipoInvestimento = tipoInvestimento;
		this.aplicacaoFinanceira = aplicacaoFinanceira;
		this.nomeBanco = nomeBanco;
		this.valor = valor;
		this.dataInvestimento = dataInvestimento;
		this.dataVencimento = dataVencimento;
	}

	public Investimento() {
		super();
	}

	public int getCodigoInvestimento() {
		return codigoInvestimento;
	}

	public void setCodigoInvestimento(int codigoInvestimento) {
		this.codigoInvestimento = codigoInvestimento;
	}

	public String getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(String tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

	public String getAplicacaoFinanceira() {
		return aplicacaoFinanceira;
	}

	public void setAplicacaoFinanceira(String aplicacaoFinanceira) {
		this.aplicacaoFinanceira = aplicacaoFinanceira;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNmBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataInvestimento() {
		return dataInvestimento;
	}

	public void setDataInvestimento(Calendar dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}
