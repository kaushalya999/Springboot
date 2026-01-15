package ijse.springIntroNew.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ijse.springIntroNew.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    //Custom Queries can be added here
    
}
