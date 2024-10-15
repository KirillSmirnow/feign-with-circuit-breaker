package fwcb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "slow",
        url = "localhost:8080"
)
public interface SlowServerFeignClient extends SlowServerClient {

    @Override
    @PostMapping
    String performRequest(@RequestParam("delayInSeconds") int delayInSeconds);
}
