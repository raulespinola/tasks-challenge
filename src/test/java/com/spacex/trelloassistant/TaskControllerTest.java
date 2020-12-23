package com.spacex.trelloassistant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spacex.trelloassistant.controllers.TaskController;
import com.spacex.trelloassistant.entity.CategoryEntity;
import com.spacex.trelloassistant.entity.TaskEntity;
import com.spacex.trelloassistant.entity.TypeTaskEntity;
import com.spacex.trelloassistant.repository.TaskRepository;
import com.spacex.trelloassistant.services.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TaskController.class)
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskServiceImpl taskService;
    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private List<TaskEntity> taskList;
    private TypeTaskEntity typeTaskEntity;
    private CategoryEntity categoryEntity;
    private TaskEntity taskEntity;

    @BeforeEach
    void setUp() {
        typeTaskEntity = new TypeTaskEntity(1L,"T1","Tag",true,false,true);
        categoryEntity= new CategoryEntity(1L,"C1");
        taskEntity =new TaskEntity(1L,"D1","t1", categoryEntity, typeTaskEntity);

        this.taskList = new ArrayList<>();
        this.taskList.add(taskEntity);
    }

    @Test
    void listAll() throws Exception {
        given(taskService.findAll()).willReturn(this.taskList);

        this.mockMvc.perform(get("/v1/tasks/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(taskList.size())));
    }

    @Test
    void findIdTask() throws Exception {
        Long idTask = 1L;
        TaskEntity task = new TaskEntity(idTask,"D1","t1",new CategoryEntity( 1L,"C1"),new TypeTaskEntity(1L,"T1","Tag",true,false,true));
        given(taskService.findBy(idTask)).willReturn(Optional.of(task));

        this.mockMvc.perform(get("/v1/tasks/{id}",idTask))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(task.getTitle())));
    }
}