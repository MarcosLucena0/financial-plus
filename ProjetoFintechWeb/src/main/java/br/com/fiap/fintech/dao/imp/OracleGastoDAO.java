package br.com.fiap.fintech.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.Gasto;
import br.com.fiap.fintech.dao.GastoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleGastoDAO implements GastoDAO{

		private Connection conexao;
		
		@Override
		public void cadastrar(Gasto gasto) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "INSERT INTO T_GASTO (CD_GASTO, VALOR_GASTO, DESCRICAO, DATA_GASTO, CATEGORIA) VALUES (SQ_GASTO.NEXTVAL, ?, ?, ?, ?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setDouble(1, gasto.getValor());
				stmt.setString(2, gasto.getDescricao());
				java.sql.Date data = new java.sql.Date(gasto.getDtGasto().getTimeInMillis());
				stmt.setDate(3, data);
				stmt.setString(4, gasto.getCategoria());

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
		public void atualizar(Gasto gasto) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "UPDATE T_GASTO SET VALOR_GASTO = ?, DESCRICAO = ?, DATA_GASTO = ?, CATEGORIA = ? WHERE CD_GASTO = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setDouble(1, gasto.getValor());
				stmt.setString(2, gasto.getDescricao());
				java.sql.Date data = new java.sql.Date(gasto.getDtGasto().getTimeInMillis());
				stmt.setDate(3, data);
				stmt.setString(4, gasto.getCategoria());
				stmt.setInt(5, gasto.getCodigoGasto());

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
		public void remover(int codigoGasto) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "DELETE FROM T_GASTO WHERE CD_GASTO = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigoGasto);
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
		public Gasto buscar(int id) {
			Gasto gasto = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conexao = ConnectionManager.getInstance().getConnection();
				stmt = conexao.prepareStatement("SELECT * FROM T_GASTO WHERE CD_GASTO = ?");
				stmt.setInt(1, id);
				rs = stmt.executeQuery();

				if (rs.next()){
					int codigo = rs.getInt("CD_GASTO");
					double valor = rs.getDouble("VALOR_GASTO");
					String descricao = rs.getString("DESCRICAO");
					java.sql.Date data = rs.getDate("DATA_GASTO");
					Calendar dataGasto = Calendar.getInstance();
					dataGasto.setTimeInMillis(data.getTime());
					String categoria = rs.getString("CATEGORIA");
					
					gasto = new Gasto(codigo, valor,descricao, dataGasto, categoria);
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
			return gasto;
	       }

		@Override
		public List<Gasto> listar() {
			List<Gasto> lista = new ArrayList<Gasto>();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conexao = ConnectionManager.getInstance().getConnection();
				stmt = conexao.prepareStatement("SELECT * FROM T_GASTO");
				rs = stmt.executeQuery();

				//Percorre todos os registros encontrados
				while (rs.next()) {
					int codigo = rs.getInt("CD_GASTO");
					double valor = rs.getDouble("VALOR_GASTO");
					String descricao = rs.getString("DESCRICAO");
					java.sql.Date data = rs.getDate("DATA_GASTO");
					Calendar dataGasto = Calendar.getInstance();
					dataGasto.setTimeInMillis(data.getTime());
					String categoria = rs.getString("CATEGORIA");
					
					Gasto gasto = new Gasto(codigo, valor,descricao , dataGasto, categoria);
					lista.add(gasto);
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
