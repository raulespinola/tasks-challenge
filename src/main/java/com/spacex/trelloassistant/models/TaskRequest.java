package com.spacex.trelloassistant.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private Long id;

    private String description;

    private String title;

    private Long categoryId;

    private Long typeTaskId;
}
