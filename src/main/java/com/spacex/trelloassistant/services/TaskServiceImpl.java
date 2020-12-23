package com.spacex.trelloassistant.services;

import com.spacex.trelloassistant.exceptions.ObjectNotFoundException;
import com.spacex.trelloassistant.exceptions.TaskException;
import com.spacex.trelloassistant.entity.TaskEntity;
import com.spacex.trelloassistant.entity.TypeTaskEntity;

import com.spacex.trelloassistant.models.TaskRequest;
import com.spacex.trelloassistant.repository.CategoryRepository;
import com.spacex.trelloassistant.repository.TaskRepository;
import com.spacex.trelloassistant.repository.TypeTaskRepository;
import com.spacex.trelloassistant.rules.TaskRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {
    private final static Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    private TypeTaskEntity typeTask;
    @Autowired
    private TypeTaskRepository typeTaskRepo;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public String save(TaskRequest taskRequest) {
        String message = "";
        String messageError = "";
        TypeTaskEntity typeTaskValid = new TypeTaskEntity();
        TaskRules taskRules = new TaskRules(categoryRepository);

        if (taskRequest.getTypeTaskId() != null) {
            Optional<TypeTaskEntity> typetaskOptional = typeTaskRepo
                    .findById(taskRequest.getTypeTaskId());
            if (typetaskOptional.isPresent()) {
                typeTaskValid = typetaskOptional.get();
            } else {
                throw new ObjectNotFoundException("No tasktype for this ID");
            }
        }

        Optional<TaskEntity> taskValid = Optional.empty();
        try {
            taskValid = taskRules.crearObjetoTaskValido(taskRequest, typeTaskValid);
        } catch (TaskException ex) {
            messageError = ex.getMessage();
        }
        if (taskValid.isPresent()) {
            logger.info("Task Ok");
            taskRepository.save(taskValid.get());
            message = "TASK SAVE";
        } else {
            logger.error("Task not Save");
            message = "TASK NOT SAVE " + messageError;
        }
        return message;
    }

    @Override
    public Optional<TaskEntity> findBy(Long id) {
        Optional<TaskEntity> message = null;
        try {
            if (id != null) {
                message = taskRepository.findById(id);
            }
        } catch (ObjectNotFoundException ob) {
            logger.error(ob.getMessage());
        }
        return message;
    }

    @Override
    public String deleteBy(Long id) {
        String message = null;
        try {
            if (id != null) {
                taskRepository.deleteById(id);
                message = "ID FOUND";
            }

        } catch (ObjectNotFoundException ob) {
            String messageObError = ob.getMessage();
        }
        return message;
    }

    @Override
    public TaskEntity updateTask(TaskEntity taskEntity) {
        TaskEntity taskEntityDb = taskEntity;
        taskEntityDb.setCategoryEntity(taskEntity.getCategoryEntity());
        taskEntityDb.setDescription(taskEntity.getDescription());
        taskEntityDb.setTitle(taskEntity.getTitle());
        taskEntityDb.setTypeTaskEntity(taskEntity.getTypeTaskEntity());
        return taskRepository.save(taskEntityDb);
    }

}
