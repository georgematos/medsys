package com.unifolio.medsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.unifolio.medsys.domain.Especialidade;
import com.unifolio.medsys.dto.EspecialidadeDTO;
import com.unifolio.medsys.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {

	@Autowired
	EspecialidadeRepository repository;

	public Page<EspecialidadeDTO> findAll(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<EspecialidadeDTO> especialidadesDTO = repository.findAll(pageRequest).map(e -> new EspecialidadeDTO(e));
		return especialidadesDTO;
	}

	public Especialidade findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void saveAll(List<Especialidade> especialidades) {
		repository.saveAll(especialidades);
	}

	public Especialidade save(Especialidade especialidade) {
		return repository.save(especialidade);
	}

	public Especialidade update(Long id, Especialidade especialidade) {
		Especialidade entityToUpdate = prepareEntityToUpdate(id, especialidade);
		
		return repository.save(entityToUpdate);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Especialidade prepareEntityToUpdate(Long id, Especialidade especialidade) {

		Especialidade entity = repository.findById(id).get();

		if (especialidade.getNome() != null)
			entity.setNome(especialidade.getNome());
		if (especialidade.getDescricao() != null)
			entity.setDescricao(especialidade.getDescricao());
		entity.setAtivo(especialidade.isAtivo());

		return entity;
	}
}
