package crud_operation_spring.crud_operation_spring.test;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")

public class helloWorld {
    @GetMapping("/hello")
    public String sayHello() {
        return "Namaskaram Spring Boot";
    }

    ;
}
