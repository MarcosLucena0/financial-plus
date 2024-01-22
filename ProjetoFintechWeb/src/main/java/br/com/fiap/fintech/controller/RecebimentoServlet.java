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

import br.com.fiap.fintech.bean.Recebimento;
import br.com.fiap.fintech.dao.RecebimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/recebimento")
public class RecebimentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private RecebimentoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getRecebimentoDAO();
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
			double valor = Double.parseDouble(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataRecebimento = Calendar.getInstance();
			dataRecebimento.setTime(format.parse(request.getParameter("dataRecebimento")));
			
			Recebimento recebimento = new Recebimento(0, valor, descricao, dataRecebimento); 
			dao.cadastrar(recebimento);
			
			request.setAttribute("msg", "Recebimento cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-recebimento.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigoRecebimento = Integer.parseInt(request.getParameter("codigoRecebimento"));
			double valor = Double.parseDouble(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dtRecebimento = Calendar.getInstance();
			dtRecebimento.setTime(format.parse(request.getParameter("dataRecebimento")));

			Recebimento recebimento = new Recebimento(codigoRecebimento, valor, descricao, dtRecebimento);
			dao.atualizar(recebimento);

			request.setAttribute("msg", "Recebimento atualizado!");
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
		int codigoRecebimento = Integer.parseInt(request.getParameter("codigoRecebimento"));
		try {
			dao.remover(codigoRecebimento);
			request.setAttribute("msg", "Recebimento removido!");
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
			int id = Integer.parseInt(request.getParameter("codigoRecebimento"));
			Recebimento recebimento = dao.buscar(id);
			request.setAttribute("recebimento", recebimento);
			request.getRequestDispatcher("edicao-recebimento.jsp").forward(request, response);
		}
	
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Recebimento> lista = dao.listar();
		request.setAttribute("recebimentos", lista);
		request.getRequestDispatcher("lista-recebimento.jsp").forward(request, response);
	}

}