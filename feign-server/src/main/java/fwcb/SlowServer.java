package fwcb;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@Slf4j
@SpringBootApplication
@RestController
public class SlowServer {

    public static void main(String[] args) {
        SpringApplication.run(SlowServer.class, args);
    }

    @RequestMapping(path = "/**", method = {RequestMethod.GET, RequestMethod.POST})
    @SneakyThrows
    public String serve(@RequestParam(defaultValue = "0") int delayInSeconds) {
        var start = System.currentTimeMillis();
        Thread.sleep(Duration.ofSeconds(delayInSeconds));
        var duration = Duration.ofMillis(System.currentTimeMillis() - start);
        log.info("Served request with delay of {}", duration);
        return "OK / %s".formatted(duration);
    }
}
