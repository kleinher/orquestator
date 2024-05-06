package com.allok.orquestator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    public record HealthCheck(String version, String environment, String mavenBuildTimestamp){}

    private final HealthCheck healthCheck;

    @Autowired
    public HealthCheckController(@Value("${app.version}") String version, @Value("${environment.name}") String environment
            , @Value("${maven.build.timestamp}") String mavenBuildTimestamp) {
        this.healthCheck = new HealthCheck(version, environment, mavenBuildTimestamp);
    }

    @GetMapping("/health-check")
    public ResponseEntity<HealthCheck> get() {
        return ResponseEntity.ok(healthCheck);
    }

    @GetMapping("/errors")
    public ResponseEntity<String> error() {
        return ResponseEntity.ok("ERROR de prueba NR");
    }

}
