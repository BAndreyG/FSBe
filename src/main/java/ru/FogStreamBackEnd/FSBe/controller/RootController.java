package ru.FogStreamBackEnd.FSBe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.FogStreamBackEnd.FSBe.AuthorizedUser;
import ru.FogStreamBackEnd.FSBe.service.UserService;
import ru.FogStreamBackEnd.FSBe.to.UserTo;
import ru.FogStreamBackEnd.FSBe.util.UserUtil;

import java.net.URI;
import java.security.Principal;
import java.util.Date;
import java.util.Map;

@Controller
public class RootController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    @GetMapping("/gettime")
    public String list(Map<String, Object> model) {
        model.put("this_time", new Date().toString() + " зщш");
        return "gettime";
    }

    @GetMapping("/registration")
    public String showRegForm(Model model) {
        log.info("registration new user");
        model.addAttribute("user", new UserTo());
        return "profile";
    }

    @PostMapping(value = "/registration/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTo> create(@RequestBody UserTo userTo) {
        log.info("created new user");
        UserTo created = service.create(userTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/registration" + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = {"/login", "/"})
    public String LoginPage() {
        return "login";
    }
}
