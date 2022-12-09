package com.spacex.trelloassistant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ModalidadES {
    VIRTUAL ("virtual"), ONLINE_VIVO("onlineVivo"), PRESENCIAL (" presencial");

    private String value;
}
