package group.aist.task_management_web_flux.service;

import group.aist.task_management_web_flux.dto.request.TaskCreateRequest;
import group.aist.task_management_web_flux.dto.response.TaskResponse;
import reactor.core.publisher.Mono;

public interface CategoryService {

    Mono<TaskResponse> getTaskById(Long id);
    Mono<Void> saveTask(TaskCreateRequest request);
}
