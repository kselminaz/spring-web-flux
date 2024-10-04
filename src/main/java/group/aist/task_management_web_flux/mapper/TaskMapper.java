package group.aist.task_management_web_flux.mapper;

import group.aist.task_management_web_flux.dto.request.TaskCreateRequest;
import group.aist.task_management_web_flux.dto.request.TaskUpdateRequest;
import group.aist.task_management_web_flux.dto.response.CategoryResponse;
import group.aist.task_management_web_flux.dto.response.TaskResponse;
import group.aist.task_management_web_flux.enums.PriorityType;
import group.aist.task_management_web_flux.enums.TaskStatus;
import group.aist.task_management_web_flux.model.Category;
import group.aist.task_management_web_flux.model.Task;
import org.springframework.stereotype.Component;

import static group.aist.task_management_web_flux.enums.TaskStatus.CREATED;
import static java.util.Optional.ofNullable;

@Component
public class TaskMapper {
    public TaskResponse buildTaskResponseWithRelation(Task entity,Category category) {
        return TaskResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(TaskStatus.getStatusById(entity.getStatus()))
                .priority(PriorityType.getPriorityById(entity.getPriority()))
                .category(CategoryResponse.builder().id(category.getId()).name(category.getName()).build())
                .deadline(entity.getDeadline())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public TaskResponse buildTaskResponse(Task entity) {
        return TaskResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(TaskStatus.getStatusById(entity.getStatus()))
                .priority(PriorityType.getPriorityById(entity.getPriority()))
                //.category(CategoryResponse.builder().id(entity.getCategory().getId()).name(entity.getCategory().getName()).build())
                .deadline(entity.getDeadline())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
    public Task requestToEntity(TaskCreateRequest request) {
        return Task.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(CREATED.getId())
                .priority(PriorityType.valueOf(request.getPriority()).getId())
                .deadline(request.getDeadline())
                .build();
    }

    public void updateTaskEntity(Task entity, TaskUpdateRequest request) {

        ofNullable(request.getName()).ifPresent(entity::setName);
        ofNullable(request.getDescription()).ifPresent(entity::setDescription);
        ofNullable(request.getStatus()).ifPresent(e->entity.setStatus(TaskStatus.valueOf(request.getStatus()).getId()));
        ofNullable(request.getPriority()).ifPresent(e->entity.setPriority(PriorityType.valueOf(request.getPriority()).getId()));
        ofNullable(request.getDeadline()).ifPresent(entity::setDeadline);

    }
/*
    public static PageableResponse<TaskResponse> buildPageableResponse(Page<TaskEntity> tasksPage) {

        var list = tasksPage.getContent().stream().map(TaskMapper::buildTaskResponse).toList();
        return PageableResponse.<TaskResponse>builder()
                .data(list)
                .hasNextPage(tasksPage.hasNext())
                .lastPageNumber(tasksPage.getTotalPages())
                .totalElements(tasksPage.getTotalElements())
                .build();

    }*/
}
