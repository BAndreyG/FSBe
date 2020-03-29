package ru.FogStreamBackEnd.FSBe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.FogStreamBackEnd.FSBe.model.News;
import ru.FogStreamBackEnd.FSBe.service.NewsService;

import java.util.List;

@Controller
@RequestMapping(value = NewsController.REST_URL) //, produces = MediaType.APPLICATION_JSON_VALUE
public class NewsController {

    static final String REST_URL ="/news";

    @Autowired
    private NewsService service;

    @GetMapping
    public String getNews(Model model){
        List<News> getAll=service.getAll();
        model.addAttribute("newsList",getAll);
        return "news";
    }

}
