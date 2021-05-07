package com.squadra.desafio.repository;

import com.squadra.desafio.domain.Sistema;
import com.squadra.desafio.dto.FilterSistemaDTO;

import java.util.List;

public interface SistemaRepoCustom {

    List<Sistema> findAllSistemasByFiltro(FilterSistemaDTO filter);

}
