package group.aist.task_management_web_flux.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum CategoryStatus {

    ACTIVE(1),DELETED(2);

    private final int id;

    public static CategoryStatus getStatusById(int id) {
        return Arrays.stream(values())
                .filter(status -> status.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
