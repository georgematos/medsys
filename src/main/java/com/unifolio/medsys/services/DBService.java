package com.unifolio.medsys.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifolio.medsys.domain.Especialidade;
import com.unifolio.medsys.domain.Medico;

@Service
public class DBService {

	@Autowired
	MedicoService medicoService;
	
	@Autowired
	EspecialidadeService especialidadeService;
	
	public void instantiateTestDatabase() throws Exception {
		
		Especialidade cardiologista = especialidadeService.save(new Especialidade("Cardiologista", "Especialidade médica designada aos cuidados com o coração"));
		Especialidade neurologista = especialidadeService.save(new Especialidade("Neurologista", "Especialidade médica designada aos cuidados com o cérebro"));
		Especialidade pneumologista = especialidadeService.save(new Especialidade("Pneumologista", "Especialidade médica designada aos cuidados com os pulmões"));
		
		Medico medico1 = new Medico("Marcelo Paes", LocalDateTime.of(1981, 04, 26, 0, 0), Arrays.asList(cardiologista, neurologista));
		Medico medico2 = new Medico("Júlio Souza", LocalDateTime.of(1978, 07, 12, 0, 0), Arrays.asList(neurologista));
		Medico medico3 = new Medico("Adriana Oliveira", LocalDateTime.of(1991, 12, 13, 0, 0), Arrays.asList(pneumologista, cardiologista));

		medicoService.saveAll(Arrays.asList(medico1, medico2, medico3));
	}
	
}
