package ru.forStreamBackEnd.FSBe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.forStreamBackEnd.FSBe.model.User;
import ru.forStreamBackEnd.FSBe.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = UserController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    static final String REST_URL ="/users";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll(){
//        int userId = SecurityUtil.authUserId();
        log.info("getAll news for user {}"); //userId
        return service.getAll();
    }

    @GetMapping("/test")
    public String test(){return "test";}

    @GetMapping("/index")
    public String getIndex(){return "index";}
}
