package com.unifolio.medsys.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Page<MedicoDTO> findAll(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);

		Page<MedicoDTO> medicosDTO = repository.findAll(pageRequest).map(m -> new MedicoDTO(m));

		return medicosDTO;
	}

	public Medico findById(Long id) {
		return repository.findById(id).get();
	}

	public Page<MedicoDTO> findMedicoByEspecialidade(Long especialidadeId, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);

		Page<MedicoDTO> medicosDTO = repository.findMedicoByEspecialidade(especialidadeId, pageRequest).map(m -> new MedicoDTO(m));

		return medicosDTO;
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