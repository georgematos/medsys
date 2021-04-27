package com.unifolio.medsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifolio.medsys.domain.Especialidade;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long>{

}
