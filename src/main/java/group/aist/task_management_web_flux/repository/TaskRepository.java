package group.aist.task_management_web_flux.repository;

import group.aist.task_management_web_flux.model.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TaskRepository extends ReactiveCrudRepository<Task, Long>{
}
