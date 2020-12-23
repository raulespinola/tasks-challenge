package com.spacex.trelloassistant.controllers;
import com.spacex.trelloassistant.entity.TaskEntity;
import com.spacex.trelloassistant.models.TaskRequest;
import com.spacex.trelloassistant.repository.TaskRepository;
import com.spacex.trelloassistant.rules.TaskRules;
import com.spacex.trelloassistant.services.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    private static Logger logger = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    private ITaskService taskService;
    private TaskRules taskRules;
    private TaskRepository taskRepository;

    @PostMapping
    public ResponseEntity<?> saveTask(@RequestBody TaskRequest taskRequest){
        String taskEntityDb =taskService.save(taskRequest);
        logger.info("New task Created");
        return ResponseEntity.status(HttpStatus.CREATED).body(taskEntityDb);

    }
    @GetMapping
    @RequestMapping("listAll")
    public ResponseEntity<?>listAll() {return ResponseEntity.ok().body(taskService.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<?>findIdTask(@PathVariable Long id) {
        Optional<TaskEntity> task = taskService.findBy(id);
        if (!task.isPresent()) {
            logger.error("ERROR TASKS NOT FOUND");
            return ResponseEntity.notFound().build();
        }
        logger.info("TASKS REQUESTED");
        return ResponseEntity.ok(task);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<?> editTask(@RequestBody TaskRequest taskEntity, @PathVariable Long id){
        Optional<TaskEntity> task1 = taskService.findBy(id);
        if(!task1.isPresent()){
            logger.error("ERROR TASKS NOT FOUND");
            return ResponseEntity.notFound().build();
        }
        TaskEntity taskEntityUpdate = taskService.updateTask(task1.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(taskEntityUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        taskService.deleteBy(id);
        logger.warn("TASKS DELETED");
        return ResponseEntity.noContent().build();
    }
    

}
