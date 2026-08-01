package com.discographyduel.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class BackendApplication {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(defaultValue = "World")String name){
		return new Greeting(counter.incrementAndGet(),template.formatted(name));
	}



}
record Greeting(long id , String content) { }