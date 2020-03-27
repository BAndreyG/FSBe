package ru.FogStreamBackEnd.FSBe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.FogStreamBackEnd.FSBe.AuthorizedUser;
import ru.FogStreamBackEnd.FSBe.model.Category;
import ru.FogStreamBackEnd.FSBe.model.User;
import ru.FogStreamBackEnd.FSBe.repository.CategoryRepo;
import ru.FogStreamBackEnd.FSBe.repository.UserRepo;
import ru.FogStreamBackEnd.FSBe.to.UserTo;
import ru.FogStreamBackEnd.FSBe.util.UserUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repo.getByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User " + s + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
