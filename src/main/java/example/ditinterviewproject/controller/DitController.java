package example.ditinterviewproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DitController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello from hello method";
    }

    @PostMapping("/create")
    public String create(){
        return "Hello from create method";
    }
    @PostMapping("/login")
    public String login(){
        return "Hello from login method";
    }
    @RequestMapping("/authenticate")
    public String authenticate(){
        return "authenticated";
    }
}
