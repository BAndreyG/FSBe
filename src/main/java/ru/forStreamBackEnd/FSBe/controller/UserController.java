package ru.forStreamBackEnd.FSBe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.forStreamBackEnd.FSBe.model.User;
import ru.forStreamBackEnd.FSBe.service.UserService;
import ru.forStreamBackEnd.FSBe.to.UserTo;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = UserController.REST_URL) //, produces = MediaType.APPLICATION_JSON_VALUE
public class UserController {

    static final String REST_URL ="/profile";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void del(@PathVariable int id){
        log.info("delete id"+id);
        service.del(id);
//        return "redirect:login";
    }

    @GetMapping
    public String getPr( Model model){
        int id=100000;
        log.info("get user id = ", id);
        User user=service.getId(id);
        model.addAttribute("user",user);
        return "profile";
    }

    @PostMapping
    public ResponseEntity<User> createOrUpdate(@RequestBody UserTo userTo){
        User created=new User();
        if (userTo.id()==0) created=service.create(userTo);
        else created=service.update(userTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
