package group.aist.task_management_web_flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableR2dbcAuditing
public class TaskManagementWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementWebFluxApplication.class, args);
    }

}
