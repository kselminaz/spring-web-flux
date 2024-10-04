package group.aist.task_management_web_flux.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum PriorityType {

    MUSTHAVE(1,"Essential tasks that are crucial for the project or goal"),
    SHOULDHAVE(2,"Important tasks but not critical. They can be included if time permits"),
    COULDHAVE(3,"Desirable tasks but not necessary. They are nice to have if resources allow"),
    WONTHAVE(4,"Tasks that are not relevant or feasible at the moment");

    private final int id;
    private final String description;

    public static PriorityType getPriorityById(int id) {
        return Arrays.stream(values())
                .filter(status -> status.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
