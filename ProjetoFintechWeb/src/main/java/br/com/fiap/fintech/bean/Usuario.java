package br.com.fiap.fintech.bean;

import java.util.Calendar;

//import br.com.fiap.fintech.util.CriptografiaUtils;

public class Usuario {
	//atributos
	private int codigoUsuario;
	private String nome;
	private Calendar dtNascimento;
	private String genero;
	private String email;
	private String senha;
	
	//construtor da classe usuario
	public Usuario(int codigoUsuario ,String nome, Calendar dtNascimento, String genero, String email, String senha) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario( String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
		//setSenha(senha);
	}
		
	public Usuario() {
		super();
	}


	//metodos getters e setters
	
	
	public String getNome() {
		return nome;
	}

	
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
		/*try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
