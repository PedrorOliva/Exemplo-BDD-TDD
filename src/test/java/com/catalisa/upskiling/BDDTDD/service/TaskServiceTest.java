package com.catalisa.upskiling.BDDTDD.service;

import com.catalisa.upskiling.BDDTDD.model.TaskModel;
import com.catalisa.upskiling.BDDTDD.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
  @Mock
  private TaskRepository taskRepository;
  @InjectMocks
  private TaskService taskService;

  @BeforeEach
  public void setUp() {
    taskService = new TaskService();
  }

  @Test
  public void testCreateTask(){
    TaskModel newTask = new TaskModel();
    newTask.setDescription("Task test");
    assertNotNull(newTask);
    assertEquals("Task test", newTask.getDescription());
    assertFalse(newTask.isCompleted());
  }

  @Test
  public void testGetTaskById() {
    TaskModel taskModel = new TaskModel();
    taskModel.setId(1L);

    when(taskRepository.findById(1L)).thenReturn(Optional.of(taskModel));
    Optional<TaskModel> result = taskService.getTaskByID(1L);

    assertTrue(result.isPresent());
    assertEquals(taskModel, result.get());
  }

  @Test
  public void testGetAllTasks() {
    TaskModel task1 = new TaskModel();
    task1.setDescription("Task test 1");
    TaskModel task2 = new TaskModel();
    task2.setDescription("Task test 2");

    when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

    List<TaskModel> taskModelList = taskService.getAllTasks();

    assertEquals(2, taskModelList.size());
    verify(taskRepository, times(1)).findAll();
  }
}
