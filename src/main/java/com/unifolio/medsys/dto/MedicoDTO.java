package com.unifolio.medsys.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.unifolio.medsys.domain.Medico;

public class MedicoDTO {

	private String nome;
	private LocalDateTime dataNascimento;
	private boolean ativo;
	private List<String> especialidades = new ArrayList<>();
	

	public MedicoDTO(Medico medico) {
		this.nome = medico.getNome();
		this.dataNascimento = medico.getDataNascimento();
		this.ativo = medico.isAtivo();
		this.especialidades = medico.getEspecialidades().stream().map(e -> e.getNome()).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<String> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<String> especialidades) {
		this.especialidades = especialidades;
	}

}
