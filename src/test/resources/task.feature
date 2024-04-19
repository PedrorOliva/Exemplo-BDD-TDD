
Feature: Gerenciador de task
  Scenario: Create a new Task
    Given I have a task description "teste"
    When I create a new task
    Then the task should be created successfully
