package ru.forStreamBackEnd.FSBe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.forStreamBackEnd.FSBe.model.User;
import ru.forStreamBackEnd.FSBe.repository.UserRepo;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public List<User> getAll(){return repo.findAll(Sort.by("surname"));}
}
