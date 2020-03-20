package ru.forStreamBackEnd.FSBe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.forStreamBackEnd.FSBe.model.Category;
import ru.forStreamBackEnd.FSBe.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(value = CategoryController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    static final String REST_URL ="/category";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoryService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getAll(){
//        int userId = SecurityUtil.authUserId();
        log.info("getAll category for user {}"); //userId
        return service.getAll();
    }



}
