package com.colheita.pa.dto.mudaDTO;

public class InsertMudaDTO {

    public InsertMudaDTO() {
    }

    // dados para ser inseridos no front end para o usuario
    private long id;
    private String regiao;
    private String solo;
    private String bioma;
    private boolean frutifera;
    private String especie;
    private String familia;
    private String nomePopular1;
    private String nomePopular2;
    private String nomeCientifico;
    private long idSolo;
    private long idRegiao;
    private long idEspecie;
    private long idbioma;
    private String nomeMuda;
    
    
    
    
    public String getNomeMuda() {
		return nomeMuda;
	}

	public void setNomeMuda(String nomeMuda) {
		this.nomeMuda = nomeMuda;
	}

	public long getIdSolo() {
		return idSolo;
	}

	public void setIdSolo(long idSolo) {
		this.idSolo = idSolo;
	}

	public long getIdRegiao() {
		return idRegiao;
	}

	public void setIdRegiao(long idRegiao) {
		this.idRegiao = idRegiao;
	}

	public long getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(long idEspecie) {
		this.idEspecie = idEspecie;
	}

	public long getIdbioma() {
		return idbioma;
	}

	public void setIdbioma(long idbioma) {
		this.idbioma = idbioma;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSolo() {
        return solo;
    }

    public void setSolo(String solo) {
        this.solo = solo;
    }

    public String getBioma() {
        return bioma;
    }

    public void setBioma(String bioma) {
        this.bioma = bioma;
    }

    public boolean isFrutifera() {
        return frutifera;
    }

    public void setFrutifera(boolean frutifera) {
        this.frutifera = frutifera;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNomePopular1() {
        return nomePopular1;
    }

    public void setNomePopular1(String nomePopular1) {
        this.nomePopular1 = nomePopular1;
    }

    public String getNomePopular2() {
        return nomePopular2;
    }

    public void setNomePopular2(String nomePopular2) {
        this.nomePopular2 = nomePopular2;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }
    
}
