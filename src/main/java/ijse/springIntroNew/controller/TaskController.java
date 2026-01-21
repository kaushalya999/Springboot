package ijse.springIntroNew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ijse.springIntroNew.entity.Task;
import ijse.springIntroNew.service.Taskservice;

@RestController
public class TaskController {

    @Autowired
    private Taskservice taskservice;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {

        List<Task> taskList = taskservice.getTasksList();
        return ResponseEntity.status(200).body(taskList);
    }

    @PostMapping("/tasks")
    public ResponseEntity<String> addTask(@RequestBody Task task) {

        if (task.getTaskName() == null || task.getTaskName() == "") {
            // return error response
            return ResponseEntity.status(422).body("Please Enter valid Name");
        }

        if (task.getPriority() == null) {
            // return error response
            return ResponseEntity.status(422).body("Please Enter valid priority");
        }

        taskservice.createTask(task);
        return ResponseEntity.status(200).body("Task Created Successfully");
    }

}
