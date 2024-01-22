package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.GastoDAO;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.dao.ObjFinanceiroDAO;
import br.com.fiap.fintech.dao.RecebimentoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.imp.OracleGastoDAO;
import br.com.fiap.fintech.dao.imp.OracleInvestimentoDAO;
import br.com.fiap.fintech.dao.imp.OracleObjFinanceiroDAO;
import br.com.fiap.fintech.dao.imp.OracleRecebimentoDAO;
import br.com.fiap.fintech.dao.imp.OracleUsuarioDAO;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static RecebimentoDAO getRecebimentoDAO() {
		return new OracleRecebimentoDAO();
	}
	
	public static GastoDAO getGastoDAO() {
		return new OracleGastoDAO();
	}
	
	public static InvestimentoDAO getInvestimentoDAO() {
		return new OracleInvestimentoDAO();
	}
	
	public static ObjFinanceiroDAO getObjFinanceiroDAO() {
		return new OracleObjFinanceiroDAO();
	}

}