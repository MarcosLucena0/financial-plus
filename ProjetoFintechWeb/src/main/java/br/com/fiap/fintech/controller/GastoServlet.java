package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Gasto;
import br.com.fiap.fintech.dao.GastoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;



@WebServlet("/gasto")
public class GastoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private GastoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getGastoDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request,response);
			break;
		case "excluir":
			excluir(request,response);
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			double valor = Double.parseDouble(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataGasto = Calendar.getInstance();
			dataGasto.setTime(format.parse(request.getParameter("dataGasto")));
			String categoria = request.getParameter("categoria");
			
			Gasto gasto = new Gasto(0, valor, descricao, dataGasto, categoria); 
			dao.cadastrar(gasto);
			
			request.setAttribute("msg", "Gasto cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-gasto.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigoGasto = Integer.parseInt(request.getParameter("codigoGasto"));
			double valor = Double.parseDouble(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dtGasto = Calendar.getInstance();
			dtGasto.setTime(format.parse(request.getParameter("dataGasto")));
			
			String categoria = request.getParameter("categoria");

			Gasto gasto = new Gasto(codigoGasto, valor, descricao, dtGasto, categoria);
			dao.atualizar(gasto);

			request.setAttribute("msg", "Gasto atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request, response);
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigoGasto = Integer.parseInt(request.getParameter("codigoGasto"));
		try {
			dao.remover(codigoGasto);
			request.setAttribute("msg", "Gasto removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		listar(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			int id = Integer.parseInt(request.getParameter("codigoGasto"));
			Gasto gasto = dao.buscar(id);
			request.setAttribute("gasto", gasto);
			request.getRequestDispatcher("edicao-gasto.jsp").forward(request, response);
		}

	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Gasto> lista = dao.listar();
		request.setAttribute("gastos", lista);
		request.getRequestDispatcher("lista-gasto.jsp").forward(request, response);	
	}
	
}
