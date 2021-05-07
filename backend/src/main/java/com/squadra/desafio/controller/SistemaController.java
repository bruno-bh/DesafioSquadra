package com.squadra.desafio.controller;


import com.squadra.desafio.business.service.SistemaService;
import com.squadra.desafio.domain.Sistema;
import com.squadra.desafio.dto.FilterSistemaDTO;
import com.squadra.desafio.dto.SistemaDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sistemas")
public class SistemaController {

    @Autowired
    private SistemaService sistemaService;

    @ApiOperation(value = "Listar todos os sistemas podendo ultilizar filtro de Email, Descrição e Sigla")
    @GetMapping("")
    public ResponseEntity<List<Sistema>> getSistemaByFilter
            (
                    @RequestParam(value = "descricao", required = false) String descricao,
                    @RequestParam(value = "sigla", required = false) String sigla,
                    @RequestParam(value = "email", required = false) String email
            ) {
        FilterSistemaDTO filterSistemaDTO = FilterSistemaDTO.builder()
                .descricao(descricao)
                .email(email)
                .sigla(sigla)
                .build();

        List<Sistema> sistemas = sistemaService.findAllSistemasByFilter(filterSistemaDTO);
        return new ResponseEntity<>(sistemas, HttpStatus.OK);
    }

    @ApiOperation(value = "Adiquirir sistema pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Sistema> getSistemaById(
            @PathVariable("id") Long id) {
        Sistema sistema = sistemaService.findSistemaById(id);
        return new ResponseEntity<>(sistema, HttpStatus.OK);
    }

    @ApiOperation(value = "Cadastrando um novo sistema")
    @PostMapping("/new")
    public ResponseEntity<Sistema> newSistema(
            @RequestBody SistemaDTO sistemaDTO) {
        Sistema novoSistema = sistemaService.newSistema(sistemaDTO);

        return new ResponseEntity<>(novoSistema, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualizando o sistema")
    @PutMapping("/sistema")
    public ResponseEntity<Sistema> getAllSistemas(
            @RequestBody Sistema sistema) {
        Sistema sistemaEditado = sistemaService.updateSistema(sistema);

        return new ResponseEntity<>(sistemaEditado, HttpStatus.OK);
    }

    @ApiOperation(value = "Deletando pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSistema(
            @PathVariable("id") Long id) {
        sistemaService.deleteSistema(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
