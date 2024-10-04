package group.aist.task_management_web_flux.repository;

import group.aist.task_management_web_flux.model.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {
}
