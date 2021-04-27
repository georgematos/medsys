package com.unifolio.medsys.dto;

import com.unifolio.medsys.domain.Especialidade;

public class EspecialidadeDTO {

	private String nome;
	private String descricao;
	private boolean ativo;

	public EspecialidadeDTO(Especialidade especialidade) {
		this.nome = especialidade.getNome();
		this.descricao = especialidade.getDescricao();
		this.ativo = especialidade.isAtivo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
