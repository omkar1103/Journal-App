package net.Omkar.journalApp.Contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/health-check")
    public  String  healthCHeck() {
        return "OK";
    }
}
