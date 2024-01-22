package br.com.fiap.fintech.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.Recebimento;
import br.com.fiap.fintech.dao.RecebimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleRecebimentoDAO implements RecebimentoDAO{

	private Connection conexao;

	@Override
	public void cadastrar(Recebimento recebimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_RECEBIMENTO (CD_RECEBIMENTO, VALOR_RECEBIMENTO, DESCRICAO, DATA_RECEBIMENTO) VALUES (SQ_RECEBIMENTO.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, recebimento.getValor());
			stmt.setString(2, recebimento.getDescricao());
			java.sql.Date data = new java.sql.Date(recebimento.getDtRecebimento().getTimeInMillis());
			stmt.setDate(3, data);

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
	public void atualizar(Recebimento recebimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_RECEBIMENTO SET VALOR_RECEBIMENTO = ?, DESCRICAO = ?, DATA_RECEBIMENTO = ? WHERE CD_RECEBIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, recebimento.getValor());
			stmt.setString(2, recebimento.getDescricao());
			java.sql.Date data = new java.sql.Date(recebimento.getDtRecebimento().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setInt(4, recebimento.getCodigoRecebimento());

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
	public void remover(int codigoRecebimento) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "DELETE FROM T_RECEBIMENTO WHERE CD_RECEBIMENTO = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigoRecebimento);
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
	public Recebimento buscar(int id) {
		Recebimento recebimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_RECEBIMENTO WHERE CD_RECEBIMENTO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_RECEBIMENTO");
				double valor = rs.getDouble("VALOR_RECEBIMENTO");
				String descricao = rs.getString("DESCRICAO");
				java.sql.Date data = rs.getDate("DATA_RECEBIMENTO");
				Calendar dataRecebimento = Calendar.getInstance();
				dataRecebimento.setTimeInMillis(data.getTime());
				
				recebimento = new Recebimento(codigo, valor,descricao, dataRecebimento);
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
		return recebimento;
	}

	@Override
	public List<Recebimento> listar() {
		List<Recebimento> lista = new ArrayList<Recebimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_RECEBIMENTO");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_RECEBIMENTO");
				double valor = rs.getDouble("VALOR_RECEBIMENTO");
				String descricao = rs.getString("DESCRICAO");
				java.sql.Date data = rs.getDate("DATA_RECEBIMENTO");
				Calendar dataRecebimento = Calendar.getInstance();
				dataRecebimento.setTimeInMillis(data.getTime());
				
				Recebimento recebimento = new Recebimento(codigo, valor,descricao , dataRecebimento);
				lista.add(recebimento);
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
