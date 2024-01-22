package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.ObjFinanceiro;
import br.com.fiap.fintech.exception.DBException;

public interface ObjFinanceiroDAO {
	
	void cadastrar(ObjFinanceiro objFinanceiro) throws DBException;

	void atualizar(ObjFinanceiro objFinanceiro) throws DBException;

	void remover(int codigoObjFinanceiro) throws DBException;

	ObjFinanceiro buscar(int id);

	List<ObjFinanceiro> listar();

}
