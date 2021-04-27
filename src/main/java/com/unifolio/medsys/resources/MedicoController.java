package com.unifolio.medsys.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unifolio.medsys.domain.Medico;
import com.unifolio.medsys.dto.MedicoDTO;
import com.unifolio.medsys.services.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	MedicoService service;

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> getMedicos() {
		List<MedicoDTO> medicos = service.findAll();

		return ResponseEntity.ok().body(medicos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MedicoDTO> findMedicoByNome(@PathVariable Long id) {
		MedicoDTO medico = new MedicoDTO(service.findById(id));

		return ResponseEntity.ok().body(medico);
	}

	@GetMapping("/especialidade/{id}")
	public ResponseEntity<List<MedicoDTO>> findMedicoByEspecialidade(@PathVariable Long id) {
		List<MedicoDTO> medicos = service.findMedicoByEspecialidade(id);

		return ResponseEntity.ok().body(medicos);
	}

	@PostMapping
	public ResponseEntity<Medico> saveMedico(@RequestBody Medico medico) {
		Medico savedEntity = service.save(medico);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();

		return ResponseEntity.created(uri).body(savedEntity);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @RequestBody Medico medico) {
		Medico savedEntity = service.update(id, medico);

		return ResponseEntity.ok().body(savedEntity);
	}

	@DeleteMapping("/{id}")
	public void deleteMedico(@PathVariable Long id) {
		service.deleteById(id);
	}
}
