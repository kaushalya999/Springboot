package ijse.springIntroNew.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/hello")
    public String sayhello(){
        return "Hello Spring Boot..!";
    }
    
    @PostMapping("/hello")
    public String postRequest(){
        return "Hello Spring Boot from Post Mapping..!";
    }
}
