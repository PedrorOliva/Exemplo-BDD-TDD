package com.catalisa.upskiling.BDDTDD.service;

import com.catalisa.upskiling.BDDTDD.model.TaskModel;
import com.catalisa.upskiling.BDDTDD.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  public TaskModel createTask(TaskModel taskModel) {
    return taskRepository.save(taskModel);
  }

  public List<TaskModel> getAllTasks() {
    return taskRepository.findAll();
  }

  public Optional<TaskModel> getTaskByID(Long id) {
    return taskRepository.findById(id);
  }

  public void deleteATask(Long id) {
    taskRepository.deleteById(id);
  }
}
