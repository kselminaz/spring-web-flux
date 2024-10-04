package group.aist.task_management_web_flux.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import group.aist.task_management_web_flux.enums.PriorityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class TaskCreateRequest {

     @NotBlank(message = "Task name is required")
     String name;

     String description;

     String priority;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     LocalDateTime deadline;

     @Positive(message = "Category Id must be greater than 0")
     Long categoryId;


}