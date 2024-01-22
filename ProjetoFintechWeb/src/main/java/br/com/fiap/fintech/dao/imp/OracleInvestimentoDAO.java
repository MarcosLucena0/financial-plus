package br.com.fiap.fintech.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleInvestimentoDAO implements InvestimentoDAO{

	private Connection conexao;

	@Override
	public void cadastrar(Investimento investimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_INVESTIMENTO (CD_INVESTIMENTO, TIPO_INVESTIMENTO, NOME_APLICACAO_FINANCEIRO, NOME_BANCO, VALOR_INVESTIMENTO, DATA_INVESTIMENTO, DATA_VENCIMENTO) VALUES (SQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, investimento.getTipoInvestimento());
			stmt.setString(2, investimento.getAplicacaoFinanceira());
			stmt.setString(3, investimento.getNomeBanco());
			stmt.setDouble(4, investimento.getValor());
			java.sql.Date data = new java.sql.Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(5, data);
			java.sql.Date dataVencimento = new java.sql.Date(investimento.getDataVencimento().getTimeInMillis());
			stmt.setDate(6, dataVencimento);

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
	public void atualizar(Investimento investimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_INVESTIMENTO SET TIPO_INVESTIMENTO = ?, NOME_APLICACAO_FINANCEIRO = ?, NOME_BANCO = ?, VALOR_INVESTIMENTO = ?, DATA_INVESTIMENTO = ?, DATA_VENCIMENTO = ? WHERE CD_INVESTIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, investimento.getTipoInvestimento());
			stmt.setString(2, investimento.getAplicacaoFinanceira());
			stmt.setString(3, investimento.getNomeBanco());
			stmt.setDouble(4, investimento.getValor());
			java.sql.Date data = new java.sql.Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(5, data);
			java.sql.Date dataVencimento = new java.sql.Date(investimento.getDataVencimento().getTimeInMillis());
			stmt.setDate(6, dataVencimento);
			stmt.setInt(7, investimento.getCodigoInvestimento());

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
	public void remover(int codigoInvestimento) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "DELETE FROM T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigoInvestimento);
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
	public Investimento buscar(int id) {
		Investimento investimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_INVESTIMENTO");
				String tpInvestimento = rs.getString("TIPO_INVESTIMENTO");
				String aplicacaoFinanceira = rs.getString("NOME_APLICACAO_FINANCEIRO");
				String nmBanco = rs.getString("NOME_BANCO");
				double valor = rs.getDouble("VALOR_INVESTIMENTO");
				java.sql.Date data = rs.getDate("DATA_INVESTIMENTO");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				java.sql.Date dataV = rs.getDate("DATA_VENCIMENTO");
				Calendar dataVencimento = Calendar.getInstance();
				dataVencimento.setTimeInMillis(dataV.getTime());
				
				investimento = new Investimento(codigo, tpInvestimento, aplicacaoFinanceira, nmBanco, valor, dataInvestimento, dataVencimento);
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
		return investimento;
	}
	
	@Override
	public List<Investimento> listar() {
		List<Investimento> lista = new ArrayList<Investimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_INVESTIMENTO");
				String tpInvestimento = rs.getString("TIPO_INVESTIMENTO");
				String aplicacaoFinanceira = rs.getString("NOME_APLICACAO_FINANCEIRO");
				String nmBanco = rs.getString("NOME_BANCO");
				double valor = rs.getDouble("VALOR_INVESTIMENTO");
				java.sql.Date data = rs.getDate("DATA_INVESTIMENTO");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				java.sql.Date dataV = rs.getDate("DATA_VENCIMENTO");
				Calendar dataVencimento = Calendar.getInstance();
				dataVencimento.setTimeInMillis(dataV.getTime());
				
				Investimento investimento = new Investimento(codigo, tpInvestimento, aplicacaoFinanceira, nmBanco, valor, dataInvestimento , dataVencimento);
				lista.add(investimento);
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
