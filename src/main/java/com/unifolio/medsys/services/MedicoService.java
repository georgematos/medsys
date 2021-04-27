package com.unifolio.medsys.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifolio.medsys.domain.Especialidade;
import com.unifolio.medsys.domain.Medico;
import com.unifolio.medsys.dto.MedicoDTO;
import com.unifolio.medsys.repository.EspecialidadeRepository;
import com.unifolio.medsys.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	MedicoRepository repository;

	@Autowired
	EspecialidadeRepository especialidadeRepository;

	public List<MedicoDTO> findAll() {
		return repository.findAll().stream().map(m -> new MedicoDTO(m)).collect(Collectors.toList());
	}

	public Medico findById(Long id) {
		return repository.findById(id).get();
	}

	public List<MedicoDTO> findMedicoByEspecialidade(Long especialidadeId) {
		return repository.findMedicoByEspecialidade(especialidadeId).stream().map(m -> new MedicoDTO(m))
				.collect(Collectors.toList());
	}

	public void saveAll(List<Medico> medicos) {
		repository.saveAll(medicos);
	}

	public Medico save(Medico medico) {

		List<Especialidade> especialidades = medico.getEspecialidades().stream()
				.map(e -> especialidadeRepository.findById(e.getId()).get()).collect(Collectors.toList());
		medico.setEspecialidade(especialidades);

		return repository.save(medico);

	}

	public Medico update(Long id, Medico medico) {
		Medico entityToUpdate = prepareEntityToUpdate(id, medico);

		return repository.save(entityToUpdate);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Medico prepareEntityToUpdate(Long id, Medico medico) {

		Medico entity = repository.findById(id).get();

		if (medico.getNome() != null)
			entity.setNome(medico.getNome());
		if (medico.getDataNascimento() != null)
			entity.setDataNascimento(medico.getDataNascimento());
		if (medico.getEspecialidades() != null)
			entity.setEspecialidade(medico.getEspecialidades());
		entity.setAtivo(medico.isAtivo());

		return entity;
	}

}