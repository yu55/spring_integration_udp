package pl.yu55.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-integration-udp.xml")
public class SpringIntegrationUdpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationUdpApplication.class, args);

        while (true) {
        }
    }
}
