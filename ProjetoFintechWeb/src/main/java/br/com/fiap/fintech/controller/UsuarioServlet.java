package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;


@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String nome = request.getParameter("nome");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar nascimento = Calendar.getInstance();
			nascimento.setTime(format.parse(request.getParameter("nascimento")));
			String genero = request.getParameter("genero");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario usuario = new Usuario(0, nome, nascimento, genero, email, senha); 
			dao.cadastrar(usuario);
			
			request.setAttribute("msg", "Usuario cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-usuario.jsp").forward(request, response);
	}

}