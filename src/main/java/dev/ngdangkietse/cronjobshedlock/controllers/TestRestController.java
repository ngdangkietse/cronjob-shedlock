package dev.ngdangkietse.cronjobshedlock.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ngdangkietse
 * @since 3/18/2024
 */

@RestController
@RequestMapping("/api/v1")
public class TestRestController {

    @GetMapping("/ping")
    public String pingPong() {
        return "Pong";
    }
}
