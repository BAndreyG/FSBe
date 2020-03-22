package ru.forStreamBackEnd.FSBe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class RootController {

    @GetMapping("/gettime")
    public String list(Map<String, Object> model) {
        model.put("this_time",new Date().toString());
        return "gettime";
    }
}
