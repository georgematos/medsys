package com.unifolio.medsys.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unifolio.medsys.domain.Especialidade;
import com.unifolio.medsys.dto.EspecialidadeDTO;
import com.unifolio.medsys.services.EspecialidadeService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

	@Autowired
	EspecialidadeService service;

	@GetMapping
	public ResponseEntity<Page<EspecialidadeDTO>> getEspecialidades(
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
		Page<EspecialidadeDTO> especialidades = service.findAll(page, size);

		return ResponseEntity.ok().body(especialidades);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EspecialidadeDTO> findEspecialidadeById(@PathVariable Long id) {
		EspecialidadeDTO especialidade = new EspecialidadeDTO(service.findById(id));

		return ResponseEntity.ok().body(especialidade);
	}

	@PostMapping
	public ResponseEntity<Especialidade> saveEspecialidade(@RequestBody Especialidade medico) {
		Especialidade savedEntity = service.save(medico);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();

		return ResponseEntity.created(uri).body(savedEntity);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Especialidade> updateMedico(@PathVariable Long id, @RequestBody Especialidade medico) {
		Especialidade savedEntity = service.update(id, medico);

		return ResponseEntity.ok().body(savedEntity);
	}

	@DeleteMapping("/{id}")
	public void deleteEspecialidade(@PathVariable Long id) {
		service.deleteById(id);
	}

}
