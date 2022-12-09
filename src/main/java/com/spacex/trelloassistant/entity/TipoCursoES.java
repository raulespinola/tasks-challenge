package com.spacex.trelloassistant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoCurso {

        CONFERENCIA("conferencia"), SEMINARIO("seminario"), TALLER("taller"),
        DIPLOMADO("diplomado"), PROGRAMA_ESPECIALIZADO("programEspecializado"),
        CONVOCATORIA("convocatoria"), ASESORIA_GRUPAL("asesoriaGrupal");

        private String value;

}
