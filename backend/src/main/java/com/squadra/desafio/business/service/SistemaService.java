package com.squadra.desafio.business.service;

import com.squadra.desafio.domain.Sistema;
import com.squadra.desafio.domain.StatusEnum;
import com.squadra.desafio.dto.FilterSistemaDTO;
import com.squadra.desafio.dto.SistemaDTO;
import com.squadra.desafio.exception.SistemaNotFoundException;
import com.squadra.desafio.repository.SistemaRepo;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SistemaService {

    @Autowired
    private final SistemaRepo sistemaRepo;


    public List<Sistema> findAllSistemas() {
        return sistemaRepo.findAll();
    }

    public List<Sistema> findAllSistemasByFilter(FilterSistemaDTO filter) {
        if (checkIfAllFieldsAreEmpty(filter)) {
            return findAllSistemas();
        }

        return sistemaRepo.findAllSistemasByFiltro(filter);
    }

    public Sistema updateSistema(Sistema sistema) {
        return sistemaRepo.save(sistema);
    }

    public Sistema newSistema(SistemaDTO sistemadto) {

        Sistema newSistema = Sistema.builder()
                .email(sistemadto.getEmail())
                .sigla(sistemadto.getSigla())
                .descricao(sistemadto.getDescricao())
                .url(sistemadto.getUrl())
                .status(StatusEnum.ATIVO.name())
                .build();

        return sistemaRepo.save(newSistema);
    }

    @Transactional
    public void deleteSistema(Long id) {
        sistemaRepo.deleteSistemaById(id);
    }

    public Sistema findSistemaById(Long id) {
        return sistemaRepo.findSistemaById(id)
                .orElseThrow(() -> new SistemaNotFoundException("Não encontrado by id " + id));
    }


    private boolean checkIfAllFieldsAreEmpty(FilterSistemaDTO filter) {
        return StringUtils.isBlank(filter.getEmail()) && StringUtils.isBlank(filter.getSigla()) && StringUtils.isBlank(filter.getDescricao());
    }


}
