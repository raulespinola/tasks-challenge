package com.spacex.trelloassistant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum TipoCursoEN {
    CONFERENCE("Conference"), SEMINAR("Seminar"), WORKSHOP("Workshop"),
    DIPLOMAT("diplomat"), SPECIALIZED_PROGRAM("specialized program"),
    ANNOUNCEMENT(" Announcement"), GROUP_COUNSELING(" group counseling");

    private String value;








}
