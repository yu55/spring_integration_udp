package pl.yu55;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-integration-context-01.xml")
public class SpringIntegrationTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationTutorialApplication.class, args);
    }
}
