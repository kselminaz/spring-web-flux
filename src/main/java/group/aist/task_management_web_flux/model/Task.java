package group.aist.task_management_web_flux.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
@Builder
@FieldDefaults(level = PRIVATE)
//Entity yazmaga ehtiyac yoxdur
public class Task {
    //Generation Type la id teyin edilmir,id in teyini migration da yazilir.
    @Id
    Long id;

    String name;

    String description;

    Long createdByUser;

    Integer status;

    Integer priority;

    LocalDateTime deadline;

    Long categoryId;

    //R2DBC relation larda mapping i qura bilmediyi uchun Transienti atiriq ki bu fieldi maplemesin
    @Transient
    Category category;

    //Bunun uchun @EnableR2dbcAuditing annotation u qeyd edilmelidir
    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
