package group.aist.task_management_web_flux.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum TaskStatus {

    CREATED(1),IN_PROGRESS(2),COMPLETED(3),CANCELLED(4),DELETED(5);

    private final int id;

    public static TaskStatus getStatusById(int id) {
        return Arrays.stream(values())
                .filter(status -> status.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
