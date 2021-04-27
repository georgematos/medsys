package com.unifolio.medsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.unifolio.medsys.domain.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
	@Query("SELECT m FROM Medico m "
			+ "JOIN m.especialidades e "
			+ "ON e.id = :especialidadeId")
	public List<Medico> findMedicoByEspecialidade(
		@RequestParam Long especialidadeId
	);
}
