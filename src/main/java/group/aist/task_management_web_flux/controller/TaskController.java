package group.aist.task_management_web_flux.controller;

import group.aist.task_management_web_flux.dto.request.TaskCreateRequest;
import group.aist.task_management_web_flux.dto.request.TaskUpdateRequest;
import group.aist.task_management_web_flux.dto.response.TaskResponse;
import group.aist.task_management_web_flux.model.Task;
import group.aist.task_management_web_flux.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/{id}")
    public Mono<TaskResponse> getTask(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @GetMapping
    public Flux<TaskResponse> getTasks() {
        return service.getTasks();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<Task> saveTask(@Valid @RequestBody TaskCreateRequest request) {
        return service.saveTask(request);
    }
    @PutMapping("/{id}")
    public Mono<Task> updateTask(@PathVariable Long id,@Valid @RequestBody TaskUpdateRequest request) {
        return service.updateTask(id,request);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteTask(@PathVariable Long id) {
        return service.deleteTask(id);
    }


}
