package dao;

import model.Entrega;
import util.Conexao;

import java.sql.*;
import java.util.*;

public class EntregaDAO {
    public void inserir(Entrega entrega) {
        String sql = "INSERT INTO entrega (id_cliente, id_motorista, id_veiculo, id_carga, data_entrega) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, entrega.getIdCliente());
            stmt.setInt(2, entrega.getIdMotorista());
            stmt.setInt(3, entrega.getIdVeiculo());
            stmt.setInt(4, entrega.getIdCarga());
            stmt.setDate(5, new java.sql.Date(entrega.getDataEntrega().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void atualizar(Entrega entrega) {
        String sql = "UPDATE entrega SET id_cliente=?, id_motorista=?, id_veiculo=?, id_carga=?, data_entrega=? WHERE id=?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, entrega.getIdCliente());
            stmt.setInt(2, entrega.getIdMotorista());
            stmt.setInt(3, entrega.getIdVeiculo());
            stmt.setInt(4, entrega.getIdCarga());
            stmt.setDate(5, new java.sql.Date(entrega.getDataEntrega().getTime()));
            stmt.setInt(6, entrega.getId());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM entrega WHERE id=?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Entrega buscarPorId(int id) {
        String sql = "SELECT * FROM entrega WHERE id=?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Entrega(rs.getInt("id"), rs.getInt("id_cliente"), rs.getInt("id_motorista"), rs.getInt("id_veiculo"), rs.getInt("id_carga"), rs.getDate("data_entrega"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Entrega> listarTodos() {
        List<Entrega> lista = new ArrayList<>();
        String sql = "SELECT * FROM entrega";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Entrega(rs.getInt("id"), rs.getInt("id_cliente"), rs.getInt("id_motorista"), rs.getInt("id_veiculo"), rs.getInt("id_carga"), rs.getDate("data_entrega")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
}
