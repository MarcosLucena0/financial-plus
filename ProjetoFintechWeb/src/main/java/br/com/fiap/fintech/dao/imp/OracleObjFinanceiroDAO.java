package br.com.fiap.fintech.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.ObjFinanceiro;
import br.com.fiap.fintech.dao.ObjFinanceiroDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleObjFinanceiroDAO implements ObjFinanceiroDAO{
	
	private Connection conexao;

	@Override
	public void cadastrar(ObjFinanceiro objFinanceiro) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_OBJ_FINANCEIRO (CD_OBJ_FINANCEIRO, NOME_OBJ_FINANCEIRO, VALOR_OBJ_FINANCEIRO, DESCRICAO, DATA_OBJ_FINANCEIRO) VALUES (SQ_OBJ_FINANCEIRO.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, objFinanceiro.getNomeObjFinanceiro());
			stmt.setDouble(2, objFinanceiro.getValor());
			stmt.setString(3, objFinanceiro.getDescricao());
			
			java.sql.Date data = new java.sql.Date(objFinanceiro.getDataObjFinanceiro().getTimeInMillis());
			stmt.setDate(4, data);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void atualizar(ObjFinanceiro objFinanceiro) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_OBJ_FINANCEIRO SET NOME_OBJ_FINANCEIRO = ?, VALOR_OBJ_FINANCEIRO = ?, DESCRICAO = ?, DATA_OBJ_FINANCEIRO = ? WHERE CD_OBJ_FINANCEIRO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, objFinanceiro.getNomeObjFinanceiro());
			stmt.setDouble(2, objFinanceiro.getValor());
			stmt.setString(3, objFinanceiro.getDescricao());
			
			java.sql.Date data = new java.sql.Date(objFinanceiro.getDataObjFinanceiro().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setInt(5, objFinanceiro.getCodigoObjFinanceiro());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	@Override
	public void remover(int codigoObjFinanceiro) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "DELETE FROM T_OBJ_FINANCEIRO WHERE CD_OBJ_FINANCEIRO = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigoObjFinanceiro);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("Erro ao remover.");
			} finally {
				try {
					stmt.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	
	@Override
	public ObjFinanceiro buscar(int id) {
		ObjFinanceiro objFinanceiro = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_OBJ_FINANCEIRO WHERE CD_OBJ_FINANCEIRO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigoObjFinanceiro = rs.getInt("CD_OBJ_FINANCEIRO");
				String nomeObjFinanceiro = rs.getString("NOME_OBJ_FINANCEIRO");
				double valor = rs.getDouble("VALOR_OBJ_FINANCEIRO");
				String descricao = rs.getString("DESCRICAO");
				
				java.sql.Date data = rs.getDate("DATA_OBJ_FINANCEIRO");
				Calendar dataObjFinanceiro = Calendar.getInstance();
				dataObjFinanceiro.setTimeInMillis(data.getTime());
				
				objFinanceiro = new ObjFinanceiro(codigoObjFinanceiro, nomeObjFinanceiro, valor, descricao, dataObjFinanceiro);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objFinanceiro;
	}
	
	@Override
	public List<ObjFinanceiro> listar() {
		List<ObjFinanceiro> lista = new ArrayList<ObjFinanceiro>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_OBJ_FINANCEIRO");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigoObjFinanceiro = rs.getInt("CD_OBJ_FINANCEIRO");
				String nomeObjFinanceiro = rs.getString("NOME_OBJ_FINANCEIRO");
				double valor = rs.getDouble("VALOR_OBJ_FINANCEIRO");
				String descricao = rs.getString("DESCRICAO");
				
				java.sql.Date data = rs.getDate("DATA_OBJ_FINANCEIRO");
				Calendar dataObjFinanceiro = Calendar.getInstance();
				dataObjFinanceiro.setTimeInMillis(data.getTime());
				
				ObjFinanceiro objFinanceiro = new ObjFinanceiro(codigoObjFinanceiro, nomeObjFinanceiro, valor, descricao , dataObjFinanceiro);
				lista.add(objFinanceiro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

}
