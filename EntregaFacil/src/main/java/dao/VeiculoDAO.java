package dao;

import model.Veiculo;
import util.Conexao;

import java.sql.*;
import java.util.*;

public class VeiculoDAO {
	//CREATE
    public void inserir(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa, modelo, capacidade) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setDouble(3, veiculo.getCapacidadeKg());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    
    // READ
    public List<Veiculo> listarTodos() {
        List<Veiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM veiculo";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Veiculo(rs.getInt("id"), rs.getString("placa"), rs.getString("modelo"), rs.getDouble("capacidade")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
    
    // UPDATE
    public void atualizar(Veiculo veiculo) {
        String sql = "UPDATE veiculo SET placa=?, modelo=?, capacidade=? WHERE id=?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setDouble(3, veiculo.getCapacidadeKg());
            stmt.setInt(4, veiculo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // DELETE
    public void excluir(int id) {
        String sql = "DELETE FROM veiculo WHERE id=?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Veiculo buscarPorId(int id) {
        String sql = "SELECT * FROM veiculo WHERE id=?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Veiculo(rs.getInt("id"), rs.getString("placa"), rs.getString("modelo"), rs.getDouble("capacidade"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}