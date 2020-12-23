package com.spacex.trelloassistant.rules;

import com.spacex.trelloassistant.entity.CategoryEntity;
import com.spacex.trelloassistant.exceptions.ObjectNotFoundException;
import com.spacex.trelloassistant.exceptions.TaskException;
import com.spacex.trelloassistant.entity.TaskEntity;
import com.spacex.trelloassistant.entity.TypeTaskEntity;
import com.spacex.trelloassistant.models.TaskRequest;
import com.spacex.trelloassistant.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


public class TaskRules {
    private static Logger logger = LoggerFactory.getLogger(TaskRules.class);

    private CategoryRepository categoryRepository;
    private TaskEntity validTask;

    public TaskRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this. validTask = new TaskEntity();
    }

    public Optional<TaskEntity> crearObjetoTaskValido(TaskRequest taskRequest,
                                                      TypeTaskEntity tipoTarea) throws TaskException {
        Optional<TaskEntity> saveOptionalTask = Optional.empty();

        if (applyRuleCategory(taskRequest, tipoTarea) == true
                && applyRuleTitle(taskRequest, tipoTarea) == true
                && applyRuleDescription(taskRequest, tipoTarea) == true) {
            saveOptionalTask = Optional.of(validTask);
        }

        return saveOptionalTask;
    }

    private boolean applyRuleCategory(TaskRequest taskRequest,
                                      TypeTaskEntity tipoTarea) throws TaskException {
        boolean response = true;
        if (tipoTarea.isHasCategory()) {
            if (taskRequest.getCategoryId() != null) {
                Optional<CategoryEntity> categoryEntity = categoryRepository.findById(taskRequest.getCategoryId());
                if (categoryEntity.isPresent()) {
                    validTask.setCategoryEntity(categoryEntity.get());
                    response = true;
                } else {
                    response = false;
                    throw new ObjectNotFoundException("Categproa Np Encpntrada: " + tipoTarea.getType());
                }
            } else {
                response = false;
                throw new TaskException("Missing Category: " + tipoTarea.getType());
            }
        } else if (taskRequest.getCategoryId() != null) {
            response = false;
            throw new TaskException("No deberia tener categoria una tarea: " + tipoTarea.getType());
        }
        return response;
    }

    private boolean applyRuleTitle(TaskRequest taskRequest,
                                   TypeTaskEntity tipoTarea) throws TaskException {
        boolean response = true;
        if (tipoTarea.isHasTitle()) {
            if (taskRequest.getTitle() != null) {
                validTask.setTitle(taskRequest.getTitle());
                response = true;
            } else {
                response = false;
                throw new TaskException("Falta Titulo: " + tipoTarea.getType());
            }
        } else if (taskRequest.getTitle() != null) {
            response = false;
            throw new TaskException("No deberia tener titulo :" + tipoTarea.getType());
        }
        return response;
    }

    private boolean applyRuleDescription(TaskRequest taskRequest, TypeTaskEntity tipoTarea) throws TaskException {
        boolean response = true;
        if (tipoTarea.isHasDescription()) {
            if (taskRequest.getDescription() != null) {
                validTask.setDescription(taskRequest.getDescription());
                response = true;
            } else {
                response = false;
                throw new TaskException("falta descripcion para una: " + tipoTarea.getType());
            }
        } else if (taskRequest.getDescription() != null) {
            response = false;
            throw new TaskException("no deberia tener descripcion una " + tipoTarea.getType());
        }
        return response;
    }

}


