package ru.FogStreamBackEnd.FSBe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.FogStreamBackEnd.FSBe.AuthorizedUser;
import ru.FogStreamBackEnd.FSBe.View;
import ru.FogStreamBackEnd.FSBe.model.User;
import ru.FogStreamBackEnd.FSBe.service.NewsService;
import ru.FogStreamBackEnd.FSBe.service.UserService;
import ru.FogStreamBackEnd.FSBe.to.UserTo;
import ru.FogStreamBackEnd.FSBe.util.UserUtil;

import javax.validation.Valid;
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
        model.put("this_time",new Date().toString()+" зщш");
        return "gettime";
    }

    @GetMapping("/registration")
    public String showRegForm(Model model){
        log.info("registration new user");
        model.addAttribute("user", new UserTo());
        return "profile";
    }

    //public ResponseEntity<User> createWithLocation(@Validated(View.Web.class) @RequestBody User meal) {}

    @PostMapping(value = "/registration/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@Valid UserTo userTo, BindingResult bindingResult){//, @RequestBody UserTo userTo
        // TODO ВАЛИДАЦИЮ ДОДЕлатАЬ!!
//        User created=new User();
        log.info("created new user");
        User created=service.create(userTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/registration" + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = {"/login","/"})
    public String getNews(Model model){
        log.info("get login ");
        return "login";
    }

    @PostMapping(value = {"/login","/"})
    public String getPr( Model model, Principal principal){
        AuthorizedUser loginedUser = (AuthorizedUser) ((Authentication) principal).getPrincipal();
        int id=loginedUser.getUser().id();
        log.info("get user id = ", id);
        model.addAttribute("user", UserUtil.convertUserTo(service.getId(id),new UserTo()));
        return "profile";
    }
}
