package ijse.springIntroNew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ijse.springIntroNew.entity.Task;
import ijse.springIntroNew.repositoty.TaskRepository;

@Service
public class TaskServiceImpl implements Taskservice {

    @Autowired // Automatically injecting the dependancies
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasksList() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

}
