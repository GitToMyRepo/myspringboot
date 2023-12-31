package com.mywork.myspringboot.control;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HealthController {

    @GetMapping("/api/health")
    public String healthCheck() {
        return "OK";
    }
}