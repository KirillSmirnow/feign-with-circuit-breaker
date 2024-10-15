package fwcb;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@RequiredArgsConstructor
public class DemoRunner {

    private final SlowServerClient slowServerClient;
    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private final AtomicInteger counter = new AtomicInteger();

    @SneakyThrows
    public void run() {
        while (true) {
            executor.submit(this::request);
            Thread.sleep(100);
        }
    }

    private void request() {
        var id = counter.incrementAndGet();
        var start = System.currentTimeMillis();

        String result;
        try {
            var slow = LocalDateTime.now().getMinute() % 2 == 0;
            var response = slowServerClient.performRequest(slow ? 100 : 0);
            result = response;
        } catch (Exception e) {
            result = e.getMessage();
            if (e.getCause() != null) {
                var causeMessage = e.getCause().getMessage();
                if (causeMessage != null) {
                    result += " | " + causeMessage;
                }
            }
        }

        var finish = System.currentTimeMillis();
        var duration = Duration.ofMillis(finish - start);
        log.info(String.format("%3s. %10s. Duration: %s", id, result, duration));
    }
}
