package com.colheita.pa.dto.mudaDTO;

import java.util.ArrayList;



import com.colheita.pa.entities.Regiao;

public class UpdateMudaDTO {


    private long id;
    private boolean frutifera;
    private String nomeMuda;
    private ArrayList<Regiao> regioes = new ArrayList<>();

    public UpdateMudaDTO() {
    	
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

	public ArrayList<Regiao> getRegioes() {
		return regioes;
	}

	public void setRegioes(ArrayList<Regiao> regioes) {
		this.regioes = regioes;
	}

    public Object getBioma() {
        return null;
    }

    public Object getSolo() {
        return null;
    }

    public Object getRegiao() {
        return null;
    }

    public Object getEspecie() {
        return null;
    }

	public Object getFamilia(){
		return null;
	}
    
    
    
}
