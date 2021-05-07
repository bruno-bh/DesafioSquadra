package com.squadra.desafio.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilterSistemaDTO {

    private String email;

    private String sigla;

    private String descricao;

}
