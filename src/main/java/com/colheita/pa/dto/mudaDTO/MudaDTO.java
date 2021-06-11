package com.colheita.pa.dto.mudaDTO;

import java.util.ArrayList;
import java.util.List;

import com.colheita.pa.entities.Muda;
import com.colheita.pa.entities.Regiao;
import com.colheita.pa.entities.Solo;
import com.colheita.pa.entities.Bioma;
import com.colheita.pa.entities.Especie;

public class MudaDTO {

	private long id;
    private boolean frutifera;
    private String nomeMuda;
    private List<Regiao> regioes = new ArrayList<>();
	private List<Bioma> biomas = new ArrayList<>();
	private List<Solo> solos = new ArrayList<>();
	private Especie especie;

    public MudaDTO(long id, boolean frutifera, String nomeMuda, ArrayList<Regiao> regioes, ArrayList<Bioma> biomas) {
		this.id = id;
		this.frutifera = frutifera;
		this.nomeMuda = nomeMuda;
		this.regioes = regioes;
		this.biomas = biomas;
	}

	public MudaDTO() {
    	
    }

	public MudaDTO(Muda muda) {
		this.frutifera = muda.isFrutifera();
		this.nomeMuda = muda.getNomeMuda();
		this.regioes = muda.getRegioes();
		this.biomas = muda.getBiomas();
		this.solos = muda.getSolos();
		this.especie = muda.getEspecie();
	}

	public MudaDTO(Solo solo) {
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isFrutifera() {
		return frutifera;
	}

	public void setFrutifera(boolean frutifera) {
		this.frutifera = frutifera;
	}

	public String getNomeMuda() {
		return nomeMuda;
	}

	public void setNomeMuda(String nomeMuda) {
		this.nomeMuda = nomeMuda;
	}

	public List<Regiao> getRegioes() {
		return regioes;
	}

	public void setRegioes(ArrayList<Regiao> regioes) {
		this.regioes = regioes;
	}

	public void setRegioes(List<Regiao> regioes) {
		this.regioes = regioes;
	}

	public List<Bioma> getBiomas() {
		return biomas;
	}

	public void setBiomas(List<Bioma> biomas) {
		this.biomas = biomas;
	}

	public List<Solo> getSolos() {
		return solos;
	}

	public void setSolos(List<Solo> solos) {
		this.solos = solos;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	

    
}
