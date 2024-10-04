package group.aist.task_management_web_flux.service;

import group.aist.task_management_web_flux.dto.request.TaskCreateRequest;
import group.aist.task_management_web_flux.dto.request.TaskUpdateRequest;
import group.aist.task_management_web_flux.dto.response.TaskResponse;
import group.aist.task_management_web_flux.model.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {

    Mono<TaskResponse> getTaskById(Long id);
    Mono<Task> saveTask(TaskCreateRequest request);
    Flux<TaskResponse> getTasks();
    Mono<Task> updateTask(Long id, TaskUpdateRequest request);
    Mono<Void> deleteTask(Long id);
}
