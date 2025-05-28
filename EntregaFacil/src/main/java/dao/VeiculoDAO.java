package dao;

import model.Veiculo;
import util.Conexao;

import java.sql.*;
import java.util.*;

public class VeiculoDAO {
	
	//CREATE
    public void inserir(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa, modelo, capacidade) VALUES (?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection(); 
        		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setDouble(3, veiculo.getCapacidadeKg());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                veiculo.setId(rs.getInt(1));
            }

            rs.close();
            System.out.println("Veiculo inserido com sucesso! ID: " + veiculo.getId());
            
        } catch (SQLException e) { 
        	System.out.println("Erro ao inserir veiculo!\nErro:" + e.getMessage()); 
        	}
    }
    
    // READ
    public List<Veiculo> listarTodos() {
        List<Veiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM veiculo";
        
        try (Connection conn = Conexao.getConnection(); 
        		PreparedStatement stmt = conn.prepareStatement(sql); 
        		ResultSet rs = stmt.executeQuery()) {
        	
            while (rs.next()) {
            	Veiculo v = new Veiculo();
            	v.setId(rs.getInt("id"));
            	v.setPlaca(rs.getString("placa"));
            	v.setModelo(rs.getString("modelo"));
            	v.setCapacidadeKg(rs.getDouble("capacidade"));
            	
                lista.add(v);
            }
            
        } catch (SQLException e) { 
        	System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
        
        return lista;
    }
    
    // UPDATE
    // A classe veiculo não possui atributos que podem ser alterados depois de criados
    
    
    // DELETE
    public void excluir(int id) {
        String sql = "DELETE FROM veiculo WHERE id=?";
        
        try (Connection conn = Conexao.getConnection(); 
        		PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Veiculo excluído com sucesso!");
            
        } catch (SQLException e) { 
        	System.out.println("Erro ao excluir veiculo" + e.getMessage()); 
        	}
    }

    public Veiculo buscarPorId(int id) {
        String sql = "SELECT * FROM veiculo WHERE id=?";
        Veiculo v = null;
        
        try (Connection conn = Conexao.getConnection(); 
        		PreparedStatement stmt = conn.prepareStatement(sql)) {
            
        	stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	v = new Veiculo();
            	v.setId(rs.getInt("id"));
            	v.setPlaca(rs.getString("placa"));
            	v.setModelo(rs.getString("modelo"));
            	v.setCapacidadeKg(rs.getDouble("capacidade"));
                return v;
            }
            
            rs.close();
            
        } catch (SQLException e) {
        	System.out.println("Erro ao buscar veiculo por ID: " + e.getMessage());
        }
        return v;
        }
}