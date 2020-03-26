package ru.forStreamBackEnd.FSBe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.forStreamBackEnd.FSBe.model.Category;
import ru.forStreamBackEnd.FSBe.model.User;
import ru.forStreamBackEnd.FSBe.repository.CategoryRepo;
import ru.forStreamBackEnd.FSBe.repository.UserRepo;
import ru.forStreamBackEnd.FSBe.to.UserTo;
import ru.forStreamBackEnd.FSBe.util.UserUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private CategoryRepo categoryRepo;

    public List<User> getAll(){return repo.findAll(Sort.by("surname"));}

    public void del(int id){
        if (repo.existsById(id))repo.deleteById(id);
    }

    public User getId(int id) {
        return repo.getById(id);
    }


    public User create(UserTo userTo) {
        return null;
    }

    public User update(UserTo userTo) {
        User old=getId(userTo.id());
        String[] catList=userTo.getCategory().split(";");
        List<Category> list=new ArrayList<>();
        for (String s:catList) {
            list.add(categoryRepo.findByName(s));
        }
//        Arrays.stream(catList).forEach(list.add(categoryRepo.findByName()));
        return repo.save(UserUtil.convertUser(userTo,old));
    }
}
