package com.catalisa.upskiling.BDDTDD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_TASK")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 250, nullable = false)
  private String description;
  private boolean completed;
}
