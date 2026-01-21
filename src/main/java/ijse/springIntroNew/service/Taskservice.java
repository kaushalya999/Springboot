package ijse.springIntroNew.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ijse.springIntroNew.entity.Task;

@Service
public interface Taskservice {
    // what do we expect to do eith Task Entity
    List<Task> getTasksList(); // Reading

    Task createTask(Task task); // Creating

    Task getTaskById(long id); // Finding a task by its primary key

}