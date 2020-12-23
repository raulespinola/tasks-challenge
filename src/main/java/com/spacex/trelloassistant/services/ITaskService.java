package com.spacex.trelloassistant.services;

import com.spacex.trelloassistant.entity.TaskEntity;
import com.spacex.trelloassistant.models.TaskRequest;


import java.util.Optional;

public interface ITaskService {

    Iterable<TaskEntity>findAll();
    String save (TaskRequest taskRequest);
    Optional<TaskEntity> findBy(Long id);
    String deleteBy (Long id);

    TaskEntity updateTask(TaskEntity taskEntity);
}
