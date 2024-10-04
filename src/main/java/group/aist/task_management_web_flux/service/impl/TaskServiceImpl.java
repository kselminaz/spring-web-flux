package group.aist.task_management_web_flux.service.impl;

import group.aist.task_management_web_flux.dto.request.TaskCreateRequest;
import group.aist.task_management_web_flux.dto.request.TaskUpdateRequest;
import group.aist.task_management_web_flux.dto.response.TaskResponse;
import group.aist.task_management_web_flux.exception.NotFoundException;
import group.aist.task_management_web_flux.mapper.TaskMapper;
import group.aist.task_management_web_flux.model.Task;
import group.aist.task_management_web_flux.repository.CategoryRepository;
import group.aist.task_management_web_flux.repository.TaskRepository;
import group.aist.task_management_web_flux.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public Mono<TaskResponse> getTaskById(Long id) {

        return taskRepository.findById(id)
                .flatMap(task -> categoryRepository.findById(task.getCategoryId())
                        .map(category -> taskMapper.buildTaskResponseWithRelation(task,category)
                        )
                )
                .switchIfEmpty(Mono.error(new NotFoundException(String.format(
                        "Task with id [%d] was not found!", id
                ))));
        //  return getMonoTaskById(id).map(taskMapper::buildTaskResponse);
    }

    @Override
    public Mono<Task> saveTask(TaskCreateRequest request) {

        var entity = taskMapper.requestToEntity(request);
        return categoryRepository.findById(request.getCategoryId())
                .switchIfEmpty(Mono.error(new NotFoundException(String.format(
                        "Category with id [%d] was not found!", request.getCategoryId()
                )))).flatMap(category -> {
                    entity.setCategoryId(category.getId());
                    return taskRepository.save(entity);
                });

    }

    @Override
    public Flux<TaskResponse> getTasks() {
        return taskRepository.findAll().flatMap(task -> categoryRepository.findById(task.getCategoryId())
                .map(category -> taskMapper.buildTaskResponseWithRelation(task,category)
                )
        );
                //map(taskMapper::buildTaskResponse);
    }

    @Override
    public Mono<Task> updateTask(Long id, TaskUpdateRequest request) {

        return getMonoTaskById(id)
                .flatMap(task -> categoryRepository.findById(request.getCategoryId())
                        .switchIfEmpty(Mono.error(new NotFoundException(String.format(
                                "Category with id [%d] was not found!", request.getCategoryId()
                        ))))
                        .flatMap(category -> {
                            taskMapper.updateTaskEntity(task, request);
                            return taskRepository.save(task);
                        })
                );

    }

    @Override
    public Mono<Void> deleteTask(Long id) {
        return getMonoTaskById(id)
                .flatMap(taskRepository::delete);
    }

    private Mono<Task> getMonoTaskById(Long id) {
        return taskRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException(String.format(
                        "Task with id [%d] was not found!", id
                ))));
    }
   /* private TaskResponse taskWithRelations(Task task) {

        Mono<TaskResponse> mono = Mono.just(null);
        // Load the category
        if (task.getCategoryId() != null) {
            mono = mono.zipWith(categoryRepository.findById(task.getCategoryId()))
                    .map(e->taskMapper.buildTaskResponse(task,e.getT2()));
        }
        return mono;
    }*/
}
