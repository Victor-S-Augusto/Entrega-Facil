package dao;

import model.Carga;
import util.Conexao;

import java.sql.*;
import java.util.*;

public class CargaDAO {

	// CREATE
	public void inserir(Carga carga) {
		String sql = "INSERT INTO carga (descricao, peso, volume) VALUES (?, ?, ?)";
		try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, carga.getDescricao());
			stmt.setDouble(2, carga.getPeso());
			stmt.setDouble(3, carga.getVolume());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// READ
	public List<Carga> listarTodos() {
		List<Carga> lista = new ArrayList<>();
		String sql = "SELECT * FROM carga";
		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				Carga c = new Carga();
				c.setId(rs.getInt("id"));
				c.setDescricao(rs.getString("descricao"));
				c.setPeso(rs.getDouble("peso"));
				c.setVolume(rs.getDouble("volume"));
				c.setEmRota(rs.getBoolean("emRota"));
				lista.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar cargas: " + e.getMessage());
		}
		return lista;
	}

	// UPDATE
	public void atualizar(Carga carga) {
		String sql = "UPDATE carga SET descricao=?, peso=?, volume=?, emRota=?  WHERE id=?";
		try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, carga.getDescricao());
			stmt.setDouble(2, carga.getPeso());
			stmt.setDouble(3, carga.getVolume());
			stmt.setBoolean(4, carga.isEmRota());
			stmt.setInt(5, carga.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DELETE
	public void excluir(int id) {
		String sql = "DELETE FROM carga WHERE id=?";
		try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// BUSCAR POR ID
	public Carga buscarPorId(int id) {
		String sql = "SELECT * FROM carga WHERE id=?";
		try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Carga carga = new Carga();
				carga.setId(rs.getInt("id"));
				carga.setDescricao(rs.getString("descricao"));
				carga.setPeso(rs.getDouble("peso"));
				carga.setVolume(rs.getDouble("volume"));
				carga.setEmRota(rs.getBoolean("emRota"));
				
				return carga;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}