package dao;

import model.Funcionario;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

	// CREATE
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, endereco, telefone, cargo, salario, dtAdmissao) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEndereco());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getCargo());
            stmt.setDouble(5, funcionario.getSalario());
            stmt.setDate(6,  new java.sql.Date(System.currentTimeMillis()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Funcionario> listarTodos() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
        	
               while (rs.next()) {
            	   Funcionario f = new Funcionario();
                   f.setId(rs.getInt("id"));
                   f.setNome(rs.getString("nome"));
                   f.setEndereco(rs.getString("endereco"));
                   f.setTelefone(rs.getString("telefone"));
                   f.setCargo(rs.getString("cargo"));
                   f.setDtAdmissao(rs.getDate("dtAdmissao"));
                   f.setSalario(rs.getDouble("salario"));
                   
                   lista.add(f);
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
        return lista;
       }
    
    // UPDATE
    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET endereco = ?, telefone = ?, cargo = ?, salario = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getEndereco());
            stmt.setString(2, funcionario.getTelefone());
            stmt.setString(3, funcionario.getCargo());
            stmt.setDouble(4, funcionario.getSalario());
            stmt.setInt(5, funcionario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // DELETE
    public void excluir(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // BUSCAR POR ID
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getString("telefone"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getDouble("salario"));
                return f;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
 
