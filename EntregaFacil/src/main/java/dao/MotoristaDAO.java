package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Motorista;
import util.Conexao;

public class MotoristaDAO {

    // CREATE
    public void inserir(Motorista motorista) {
        String sql = "INSERT INTO Motorista (nome, endereco, telefone, cargo, dtAdmissao, salario, cnh, rota, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, motorista.getNome());
            stmt.setString(2, motorista.getEndereco());
            stmt.setString(3, motorista.getTelefone());
            stmt.setString(4, motorista.getCargo());
            stmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            stmt.setDouble(6, motorista.getSalario());
            stmt.setString(7, motorista.getCnh());
            stmt.setString(8, motorista.getRota());
            stmt.setBoolean(9, motorista.isDisponivel());

            stmt.executeUpdate();
            System.out.println("Motorista inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir motorista: " + e.getMessage());
        }
    }

    // READ
    public List<Motorista> listarTodos() {
        List<Motorista> lista = new ArrayList<>();
        String sql = "SELECT * FROM Motorista";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Motorista m = new Motorista();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setEndereco(rs.getString("endereco"));
                m.setTelefone(rs.getString("telefone"));
                m.setCargo(rs.getString("cargo"));
                m.setDtAdmissao(rs.getDate("dtAdmissao"));
                m.setSalario(rs.getDouble("salario"));
                m.setCnh(rs.getString("cnh"));
                m.setRota(rs.getString("rota"));
                m.setDisponivel(rs.getBoolean("disponivel"));

                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar motoristas: " + e.getMessage());
        }

        return lista;
    }

    // UPDATE
    public void atualizar(Motorista motorista) {
        String sql = "UPDATE Motorista SET endereco=?, telefone=?, cargo=?, dtAdmissao=?, salario=?, cnh=?, rota=?, disponivel=? WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, motorista.getEndereco());
            stmt.setString(2, motorista.getTelefone());
            stmt.setString(3, motorista.getCargo());
            stmt.setDate(4, motorista.getDtAdmissao());
            stmt.setDouble(5, motorista.getSalario());
            stmt.setString(6, motorista.getCnh());
            stmt.setString(7, motorista.getRota());
            stmt.setBoolean(8, motorista.isDisponivel());
            stmt.setInt(9, motorista.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar motorista: " + e.getMessage());
        }
    }

    // DELETE
    public void excluir(int id) {
        String sql = "DELETE FROM Motorista WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Motorista excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir motorista: " + e.getMessage());
        }
    }

    // BUSCAR POR ID
    public Motorista buscarPorId(int id) {
        String sql = "SELECT * FROM Motorista WHERE id=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	
                Motorista m = new Motorista();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setEndereco(rs.getString("endereco"));
                m.setTelefone(rs.getString("telefone"));
                m.setCargo(rs.getString("cargo"));
                m.setDtAdmissao(rs.getDate("dtAdmissao"));
                m.setSalario(rs.getDouble("salario"));
                m.setCnh(rs.getString("cnh"));
                m.setRota(rs.getString("rota"));
                m.setDisponivel(rs.getBoolean("disponivel"));
                return m;
            }

            rs.close();

        } catch (SQLException e) {
            System.out.println("Erro ao buscar motorista por ID: " + e.getMessage());
        }
        return null;
    }
}
