package com.unifolio.medsys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Medico> findMedicoByEspecialidade(
		@RequestParam Long especialidadeId,
		Pageable pageRequest
	);
	
	public Page<Medico> findAll(Pageable pageRequest);
}
