package fwcb;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class FeignWithResilience4j {

    private final DemoRunner demoRunner;

    public static void main(String[] args) {
        SpringApplication.run(FeignWithResilience4j.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        demoRunner.run();
    }
}
