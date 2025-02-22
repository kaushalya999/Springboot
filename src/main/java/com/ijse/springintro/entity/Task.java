package com.ijse.springintro.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String taskName;

    private Integer priority;

    private LocalDateTime dueDate;

    //setter
    public void setTaskName(String taskname){
        this.taskName = taskName;
    }

    //getter
    public String getTaskName(){
        return this.taskName;
    }
}
 