package com.catalisa.upskiling.BDDTDD.service;

import com.catalisa.upskiling.BDDTDD.model.TaskModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskSteps {
  private final TaskService taskService = new TaskService();
  private TaskModel taskModel;
  private TaskModel createdTask;

  @Given("I have a task description {string}")
  public void i_have_a_task_description(String description) {
    this.taskModel = new TaskModel();
    this.taskModel.setDescription(description);
  }


  @When("I create a new task")
  public void i_create_a_new_task() {
   this.createdTask = taskService.createTask(taskModel);
  }

  @Then("the task should be created successfully")
  public void the_task_should_be_created_successfully() {
    assertNotNull(createdTask);
  }
}
