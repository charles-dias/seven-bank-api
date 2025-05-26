package com.charles.sevenbankapi.benchmark;

import com.charles.sevenbankapi.adapter.in.rest.dto.AccountResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;       // <– of Spring Boot 3.x
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("h2")
class ConcurrencyBenchmarkTest {

    @LocalServerPort
    private int port;

    private final RestTemplate rest = new RestTemplate();
    private static final int REQUESTS = 100;

    private String url(long accountNumber) {
        return "http://localhost:" + port + "/accounts/" + accountNumber + "/balance";
    }

    @Test
    @DisplayName("Benchmark com platform threads")
    void benchmarkPlatformThreads() throws Exception {
        ExecutorService platformPool = Executors.newFixedThreadPool(200);
        long start = System.nanoTime();

        List<Future<BigDecimal>> futures = IntStream.range(0, REQUESTS)
                .<Future<BigDecimal>>mapToObj(i ->
                        platformPool.submit(() -> {
                            AccountResponseDto dto = rest.getForObject(url(331L), AccountResponseDto.class);
                            return dto.balance();
                        })
                )
                .toList();

        for (Future<BigDecimal> f : futures) {
            f.get();
        }

        long elapsedMs = Duration.ofNanos(System.nanoTime() - start).toMillis();
        System.out.println("Platform threads: " + elapsedMs + " ms");
        platformPool.shutdown();
    }

    @Test
    @DisplayName("Benchmark com virtual threads")
    void benchmarkVirtualThreads() throws Exception {
        try (ExecutorService virtualPool = Executors.newVirtualThreadPerTaskExecutor()) {
            long start = System.nanoTime();

            List<Future<BigDecimal>> futures = IntStream.range(0, REQUESTS)
                    .<Future<BigDecimal>>mapToObj(i ->
                            virtualPool.submit(() -> {
                                AccountResponseDto dto = rest.getForObject(url(331L), AccountResponseDto.class);
                                return dto.balance();
                            })
                    )
                    .toList();

            for (Future<BigDecimal> f : futures) {
                f.get();
            }

            long elapsedMs = Duration.ofNanos(System.nanoTime() - start).toMillis();
            System.out.println("Virtual threads: " + elapsedMs + " ms");
        }
    }
}
