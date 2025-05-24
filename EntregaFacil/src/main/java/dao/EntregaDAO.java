package dao;

import model.*;
import util.Conexao;

import java.sql.*;
import java.util.*;

public class EntregaDAO {

    public void inserir(Entrega entrega) {
        String sql = "INSERT INTO entrega (id_cliente, id_motorista, id_veiculo, id_carga, status, dt_saida, dt_entrega) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, entrega.getCliente().getId());
            stmt.setInt(2, entrega.getMotorista().getId());
            stmt.setInt(3, entrega.getVeiculo().getId());
            stmt.setInt(4, entrega.getCarga().getId());
            stmt.setString(5, entrega.getStatus());
            stmt.setDate(6, new java.sql.Date(entrega.getDtSaida().getTime()));
            stmt.setDate(7, new java.sql.Date(entrega.getDtEntrega().getTime()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Entrega entrega) {
        String sql = "UPDATE entrega SET id_cliente=?, id_motorista=?, id_veiculo=?, id_carga=?, status=?, dt_saida=?, dt_entrega=? WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, entrega.getCliente().getId());
            stmt.setInt(2, entrega.getMotorista().getId());
            stmt.setInt(3, entrega.getVeiculo().getId());
            stmt.setInt(4, entrega.getCarga().getId());
            stmt.setString(5, entrega.getStatus());
            stmt.setDate(6, new java.sql.Date(entrega.getDtSaida().getTime()));
            stmt.setDate(7, new java.sql.Date(entrega.getDtEntrega().getTime()));
            stmt.setInt(8, entrega.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM entrega WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Entrega buscarPorId(int id) {
        String sql = "SELECT * FROM entrega WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Entrega entrega = montarEntrega(rs);
                return entrega;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Entrega> listarTodos() {
        List<Entrega> lista = new ArrayList<>();
        String sql = "SELECT * FROM entrega";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Entrega entrega = montarEntrega(rs);
                lista.add(entrega);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    // Auxiliar de montagem
    private Entrega montarEntrega(ResultSet rs) throws SQLException {
        Entrega entrega = new Entrega();

        entrega.setId(rs.getInt("id"));
        entrega.setStatus(rs.getString("status"));
        entrega.setDtSaida(rs.getDate("dt_saida"));
        entrega.setDtEntrega(rs.getDate("dt_entrega"));

        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id_cliente"));
        entrega.setCliente(cliente);

        Motorista motorista = new Motorista();
        motorista.setId(rs.getInt("id_motorista"));
        entrega.setMotorista(motorista);

        Veiculo veiculo = new Veiculo();
        veiculo.setId(rs.getInt("id_veiculo"));
        entrega.setVeiculo(veiculo);

        Carga carga = new Carga();
        carga.setId(rs.getInt("id_carga"));
        entrega.setCarga(carga);

        return entrega;
    }
}
