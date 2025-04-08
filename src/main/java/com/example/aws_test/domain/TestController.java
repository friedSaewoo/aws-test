package com.example.aws_test.domain;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TestController {

    private  final TestService testService;

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<Map<String, String>> testConnection(){
        return ResponseEntity.ok(testService.test());
    }

    @GetMapping("/test/view")
    public String testView() {
        return "test-view";
    }
}
