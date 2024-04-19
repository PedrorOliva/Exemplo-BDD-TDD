package com.catalisa.upskiling.BDDTDD.repository;

import com.catalisa.upskiling.BDDTDD.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
