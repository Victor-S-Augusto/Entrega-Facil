package model;

import java.util.Date;

public class Entrega {
    private int id;
    private String status;
    private Date dtSaida;
    private Date dtEntrega;

    private Cliente cliente;
    private Motorista motorista;
    private Veiculo veiculo;
    private Carga carga;

    public Entrega() {}

    public Entrega(int id, Cliente cliente, Motorista motorista, Veiculo veiculo, Carga carga, String status, Date dtSaida, Date dtEntrega) {
        this.id = id;
        this.cliente = cliente;
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.carga = carga;
        this.status = status;
        this.dtSaida = dtSaida;
        this.dtEntrega = dtEntrega;
    }

    // Getters e Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getDtSaida() { return dtSaida; }
    public void setDtSaida(Date dtSaida) { this.dtSaida = dtSaida; }

    public Date getDtEntrega() { return dtEntrega; }
    public void setDtEntrega(Date dtEntrega) { this.dtEntrega = dtEntrega; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Motorista getMotorista() { return motorista; }
    public void setMotorista(Motorista motorista) { this.motorista = motorista; }

    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    public Carga getCarga() { return carga; }
    public void setCarga(Carga carga) { this.carga = carga; }
}
