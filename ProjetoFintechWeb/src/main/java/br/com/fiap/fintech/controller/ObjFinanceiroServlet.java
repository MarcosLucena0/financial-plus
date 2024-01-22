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

import br.com.fiap.fintech.bean.ObjFinanceiro;
import br.com.fiap.fintech.dao.ObjFinanceiroDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;


@WebServlet("/objFinanceiro")
public class ObjFinanceiroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ObjFinanceiroDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getObjFinanceiroDAO();
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
			excluir(request, response);
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String nomeObjFinanceiro = request.getParameter("nomeObjFinanceiro");
			double valor = Double.parseDouble(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataObjFinanceiro = Calendar.getInstance();
			dataObjFinanceiro.setTime(format.parse(request.getParameter("dataObjFinanceiro")));
			
			ObjFinanceiro objFinanceiro = new ObjFinanceiro(0, nomeObjFinanceiro, valor, descricao, dataObjFinanceiro); 
			dao.cadastrar(objFinanceiro);
			
			request.setAttribute("msg", "Objetivo Financeiro cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-objetivofinanceiro.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigoObjFinanceiro = Integer.parseInt(request.getParameter("codigoObjFinanceiro"));
			String nomeObjFinanceiro = request.getParameter("nomeObjFinanceiro");
			double valor = Double.parseDouble(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataObjFinanceiro = Calendar.getInstance();
			dataObjFinanceiro.setTime(format.parse(request.getParameter("dataObjFinanceiro")));

			ObjFinanceiro objFinanceiro = new ObjFinanceiro(codigoObjFinanceiro, nomeObjFinanceiro, valor, descricao, dataObjFinanceiro);
			dao.atualizar(objFinanceiro);

			request.setAttribute("msg", "Objetivo Financeiro atualizado!");
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
		int codigoObjFinanceiro = Integer.parseInt(request.getParameter("codigoObjFinanceiro"));
		try {
			dao.remover(codigoObjFinanceiro);
			request.setAttribute("msg", "Objetivo Financeiro removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		listar(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);	
			break;
		case "abrir-form-edicao":
			int id = Integer.parseInt(request.getParameter("codigoObjFinanceiro"));
			ObjFinanceiro objFinanceiro = dao.buscar(id);
			request.setAttribute("objFinanceiro", objFinanceiro);
			request.getRequestDispatcher("edicao-objfinanceiro.jsp").forward(request, response);
		}
			
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ObjFinanceiro> lista = dao.listar();
		request.setAttribute("objFinanceiros", lista);
		request.getRequestDispatcher("lista-objetivofinanceiro.jsp").forward(request, response);	
	}

}