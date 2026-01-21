package ijse.springIntroNew.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ijse.springIntroNew.entity.Task;

@Service
public interface Taskservice {
    // what do we expect to do eith Task Entity
    List<Task> getTasksList(); // Reading

    Task createTask(Task task); // Creating

    Task getTaskById(Long id); // Finding a task by its primary key

    Task updateTask(Long id, Task task); // Find Task and Update

    void deleteTask(Long id); // Delete task

}