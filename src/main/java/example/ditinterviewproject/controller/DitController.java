package example.ditinterviewproject.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import example.ditinterviewproject.bean.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DitController {



    @GetMapping("/hello")
    public String hello(ResponseBean respBean) {
        respBean.setSuccess("true");
        respBean.setError(null);
        respBean.setData("Hello, World!");
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(respBean);
    }

    @PostMapping("/create")
    public String create() {
        return "Hello from create method";
    }

    @PostMapping("/login")
    public String login() {
        return "Hello from login method";
    }

    @GetMapping("/authenticate")
    public String authenticate() {
        return "authenticated";
    }
}
