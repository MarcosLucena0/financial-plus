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

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;


@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private InvestimentoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getInvestimentoDAO();
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
			String tipoInvestimento = request.getParameter("tipoInvestimento");
			String aplicacaoFinanceira = request.getParameter("aplicacaoFinanceira");
			String nomeBanco = request.getParameter("nomeBanco");
			double valor = Double.parseDouble(request.getParameter("valor"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataInvestimento = Calendar.getInstance();
			dataInvestimento.setTime(format.parse(request.getParameter("dataInvestimento")));
			
			SimpleDateFormat formatt = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataVencimento = Calendar.getInstance();
			dataVencimento.setTime(formatt.parse(request.getParameter("dataVencimento")));
			
			Investimento investimento = new Investimento(0, tipoInvestimento, aplicacaoFinanceira, nomeBanco, valor, dataInvestimento, dataVencimento); 
			dao.cadastrar(investimento);
			
			request.setAttribute("msg", "Investimento cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-investimento.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigoInvestimento = Integer.parseInt(request.getParameter("codigoInvestimento"));
			String tipoInvestimento = request.getParameter("tipoInvestimento");
			String aplicacaoFinanceira = request.getParameter("aplicacaoFinanceira");
			String nomeBanco = request.getParameter("nomeBanco");
			double valor = Double.parseDouble(request.getParameter("valor"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataInvestimento = Calendar.getInstance();
			dataInvestimento.setTime(format.parse(request.getParameter("dataInvestimento")));
			SimpleDateFormat formatt = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataVencimento = Calendar.getInstance();
			dataVencimento.setTime(formatt.parse(request.getParameter("dataVencimento")));

			Investimento investimento = new Investimento(codigoInvestimento, tipoInvestimento, aplicacaoFinanceira, nomeBanco, valor, dataInvestimento, dataVencimento);
			dao.atualizar(investimento);

			request.setAttribute("msg", "Investimento atualizado!");
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
		int codigoInvestimento = Integer.parseInt(request.getParameter("codigoInvestimento"));
		try {
			dao.remover(codigoInvestimento);
			request.setAttribute("msg", "Investimento removido!");
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
			int id = Integer.parseInt(request.getParameter("codigoInvestimento"));
			Investimento investimento = dao.buscar(id);
			request.setAttribute("investimento", investimento);
			request.getRequestDispatcher("edicao-investimento.jsp").forward(request, response);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Investimento> lista = dao.listar();
		request.setAttribute("investimentos", lista);
		request.getRequestDispatcher("lista-investimento.jsp").forward(request, response);
	}

}