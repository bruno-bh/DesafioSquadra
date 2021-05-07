package com.squadra.desafio.repository;

import com.squadra.desafio.domain.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SistemaRepo extends JpaRepository<Sistema, Long>,SistemaRepoCustom {

    void deleteSistemaById(Long id);

    Optional<Sistema> findSistemaById(Long id);

}
