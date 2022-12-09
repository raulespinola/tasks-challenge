package com.spacex.trelloassistant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum ModalidadEN {
    VIRTUAL("virtual"), ONLINE_LIVE (" onlineLive"), FACE_TO_FACE ("faceToFace");

    private String value;
}
