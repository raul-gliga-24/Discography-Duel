package com.discographyduel.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}

@RestController                        // "Spring: this class handles web requests,
                                       //  and whatever I return should become JSON"
class PingController {

    @GetMapping("/api/ping")           // maps GET http://localhost:8080/api/ping
    PingResponse ping() {
        return new PingResponse("discographyduel", "ok");
    }

    record PingResponse(String app, String status) {}
}