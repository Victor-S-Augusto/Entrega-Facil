package model;

public class Carga {
	private int id;
	private String descricao;
	private double peso, volume; //Peso(Kg) - Volume (m³)
	private boolean emRota;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public boolean isEmRota() {
		return emRota;
	}
	public void setEmRota(boolean emRota) {
		this.emRota = emRota;
	}
	public Carga(int id, String descricao, double peso, double volume, boolean emRota) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.peso = peso;
		this.volume = volume;
		this.emRota = emRota;
	}
	
	
}
