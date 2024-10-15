# Open Feign with Circuit Breaker

* feign-server -- a server with configurable delay. Launch it first: `SlowServer`.
* feign-shared -- a lib with demo class to be used by different implementations.
* feign-resilience4j -- an app with modern resilience4j implementation of Circuit Breaker: `FeignWithResilience4j`.
* feign-hystrix -- an app with legacy Hystrix implementation of Circuit Breaker: `FeignWithHystrix`.
