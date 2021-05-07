package com.squadra.desafio.repository.impl;


import com.squadra.desafio.domain.Sistema;
import com.squadra.desafio.dto.FilterSistemaDTO;
import com.squadra.desafio.repository.SistemaRepoCustom;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SistemaRepoImpl implements SistemaRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Sistema> findAllSistemasByFiltro(FilterSistemaDTO filter) {
        Map<String, Object> params = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT sistema ");
        sql.append(" FROM Sistema sistema");
        sql.append(" WHERE ");

        if (StringUtils.isNotBlank(filter.getDescricao())) {
            sql.append(" sistema.descricao LIKE :descricao ");
            params.put("descricao", '%' + filter.getDescricao().trim() + '%');
        }

        if (StringUtils.isNotBlank(filter.getSigla())) {
            sql.append(StringUtils.isNotBlank(filter.getDescricao()) ? " OR " : "");
            sql.append(" sistema.sigla LIKE :sigla ");
            params.put("sigla", '%' + filter.getSigla().trim() + '%');
        }

        if (StringUtils.isNotBlank(filter.getEmail())) {
            sql.append(StringUtils.isNotBlank(filter.getSigla()) || StringUtils.isNotBlank(filter.getDescricao()) ? " OR " : "");
            sql.append(" sistema.email LIKE :email ");
            params.put("email", '%' + filter.getEmail().trim() + '%');
        }

        try {
            TypedQuery<Sistema> query = entityManager.createQuery(sql.toString(), Sistema.class);
            setQueryParameters(query,params);

            return query.getResultList();
        } catch (NoResultException ne) {
            return null;
        }


    }

    private void setQueryParameters(Query query, Map<String, Object> parameters) {
        for (String key : parameters.keySet()) {
            query.setParameter(key, parameters.get(key));
        }
    }

}
