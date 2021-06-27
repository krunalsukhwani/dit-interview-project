package example.ditinterviewproject.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import example.ditinterviewproject.bean.CreateResponseBean;
import example.ditinterviewproject.bean.ResponseBean;
import example.ditinterviewproject.bean.User;
import example.ditinterviewproject.service.DitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DitController {
    @Autowired
    DitService ditService;

    @GetMapping("/hello")
    public String hello(ResponseBean respBean) {
        respBean.setSuccess("true");
        respBean.setError(null);
        respBean.setData("Hello, World!");
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(respBean);
    }

    @PostMapping(value = "/create",consumes="application/json",produces ="application/json")
    public CreateResponseBean create(@RequestBody User user)
    {
        System.out.println("user value in controller: "+user.toString());
        return ditService.create(user);
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
