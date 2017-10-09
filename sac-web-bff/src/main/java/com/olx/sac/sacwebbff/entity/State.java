package com.olx.sac.sacwebbff.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_STATE")
public class State implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "ID_STATE", nullable = false)
    private Integer idState;
	
    @Column(name = "STATE", nullable = false)
    private String uf;
    
    @Column(name = "NOME", nullable = false)
    private String nome;

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}
    

}
