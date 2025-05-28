package model;

import java.util.Date;

public class Entrega {
	private int id, id_cliente, id_motorista, id_veiculo, id_carga;
	private String status;
    private Date dtSaida;
    private Date dtEntrega;
   
    
    public Entrega() {}

    public Entrega(int id, int id_cliente, int id_motorista, int id_veiculo, int id_carga, String status, Date dtSaida, Date dtEntrega) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_motorista = id_motorista;
        this.id_veiculo = id_veiculo;
        this.id_carga = id_carga;
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

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_motorista() {
		return id_motorista;
	}

	public void setId_motorista(int id_motorista) {
		this.id_motorista = id_motorista;
	}

	public int getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public int getId_carga() {
		return id_carga;
	}

	public void setId_carga(int id_carga) {
		this.id_carga = id_carga;
	}
}
