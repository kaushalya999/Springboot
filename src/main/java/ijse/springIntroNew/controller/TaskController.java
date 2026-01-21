package ijse.springIntroNew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/tasks/{id}") // add a path variable to fetch id from client id
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
        Task task = taskservice.getTaskById(id);

        if (task == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(task);
        }

    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskservice.updateTask(id, task);

        if (updatedTask == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(updatedTask);
        }
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Long id) {
        taskservice.deleteTask(id);
    }

}
