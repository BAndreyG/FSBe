package ru.forStreamBackEnd.FSBe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.forStreamBackEnd.FSBe.model.News;
import ru.forStreamBackEnd.FSBe.service.NewsService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class RootController {

    @Autowired
    private NewsService service;

    @GetMapping("/gettime")
    public String list(Map<String, Object> model) {
        model.put("this_time",new Date().toString()+" зщш");
        return "gettime";
    }

    /*@GetMapping("/profile")
    public String getProf(){
        return "profile";
    }*/

    @GetMapping("/news")
    public String getNews(Model model){
        List<News> news=service.getAll();
        model.addAttribute("newsList",news);
        return "news";
    }
}
