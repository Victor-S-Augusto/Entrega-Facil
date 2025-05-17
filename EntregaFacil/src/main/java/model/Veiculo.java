package model;

public class Veiculo {
	private int id;
	private String placa, modelo;
	private double capacidadeKg;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getCapacidadeKg() {
		return capacidadeKg;
	}
	public void setCapacidadeKg(double capacidadeKg) {
		this.capacidadeKg = capacidadeKg;
	}
}
