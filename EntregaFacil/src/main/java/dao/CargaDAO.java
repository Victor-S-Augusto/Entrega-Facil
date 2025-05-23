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
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // READ
    public List<Carga> listarTodos() {
        List<Carga> lista = new ArrayList<>();
        String sql = "SELECT * FROM carga";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Carga(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("peso"), rs.getDouble("volume"), rs.getBoolean("emRota")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    //UPDATE
    public void atualizar(Carga carga) {
        String sql = "UPDATE carga SET descricao=?, peso=?, volume=? WHERE id=?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carga.getDescricao());
            stmt.setDouble(2, carga.getPeso());
            stmt.setDouble(3, carga.getVolume());
            stmt.setInt(4, carga.getId());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // DELETE
    public void excluir(int id) {
        String sql = "DELETE FROM carga WHERE id=?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // BUSCAR POR ID
    public Carga buscarPorId(int id) {
        String sql = "SELECT * FROM carga WHERE id=?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Carga(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("peso"), rs.getDouble("volume"), rs.getBoolean("emRota"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}