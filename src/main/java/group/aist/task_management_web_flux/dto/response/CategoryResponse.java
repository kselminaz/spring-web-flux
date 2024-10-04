package group.aist.task_management_web_flux.dto.response;

import group.aist.task_management_web_flux.enums.PriorityType;
import group.aist.task_management_web_flux.enums.TaskStatus;
import group.aist.task_management_web_flux.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class CategoryResponse {

    Long id;

    String name;

}
