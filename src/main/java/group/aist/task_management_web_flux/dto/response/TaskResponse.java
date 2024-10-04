package group.aist.task_management_web_flux.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import group.aist.task_management_web_flux.enums.PriorityType;
import group.aist.task_management_web_flux.enums.TaskStatus;
import group.aist.task_management_web_flux.model.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class TaskResponse {

    Long id;

    String name;

    String description;

    TaskStatus status;

    PriorityType priority;

    @JsonFormat(pattern = "dd-MM-YYYY HH:mm")
    LocalDateTime deadline;

    CategoryResponse category;

    @JsonFormat(pattern = "dd-MM-YYYY HH:mm")
    LocalDateTime createdAt;

    @JsonFormat(pattern = "dd-MM-YYYY HH:mm")
    LocalDateTime updatedAt;

}
