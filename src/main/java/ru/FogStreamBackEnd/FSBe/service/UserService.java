package ru.FogStreamBackEnd.FSBe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.FogStreamBackEnd.FSBe.AuthorizedUser;
import ru.FogStreamBackEnd.FSBe.model.Category;
import ru.FogStreamBackEnd.FSBe.model.Role;
import ru.FogStreamBackEnd.FSBe.model.User;
import ru.FogStreamBackEnd.FSBe.repository.CategoryRepo;
import ru.FogStreamBackEnd.FSBe.repository.UserRepo;
import ru.FogStreamBackEnd.FSBe.to.UserTo;
import ru.FogStreamBackEnd.FSBe.util.UserUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static ru.FogStreamBackEnd.FSBe.model.Role.ROLE_USER;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<User> getAll(){return repo.findAll(Sort.by("surname"));}

    public void del(int id){
        if (repo.existsById(id))repo.deleteById(id);
    }

    public User getId(int id) {
        return repo.getById(id);
    }


    public UserTo create(UserTo userTo) {
        Assert.notNull(userTo, "user must not be null");
        User user=new User();
        if (userTo.getCategory()!=""){
            String[] catList=userTo.getCategory().split(";");
            List<Category> list=new ArrayList<>();
            for (String s:catList) {
                list.add(categoryRepo.findByName(s));
            }
            user.setCategories(list);
        }
        user.setPassword(passwordEncoder.encode(userTo.getPassword()));
        user=UserUtil.convertUser(userTo,user);
        return UserUtil.convertUserTo(repo.save(user),new UserTo());
    }

    public UserTo update(UserTo userTo) {
        Assert.notNull(userTo, "user must not be null");
        User old=getId(userTo.id());
        if (userTo.getCategory()!=""){
            String[] catList=userTo.getCategory().split(";");
            List<Category> list=new ArrayList<>();
            for (String s:catList) {
                list.add(categoryRepo.findByName(s));
            }
            old.setCategories(list);
        }
        if (userTo.getPassword()!="***")old.setPassword(passwordEncoder.encode(userTo.getPassword()));
        return UserUtil.convertUserTo(repo.save(UserUtil.convertUser(userTo,old)),new UserTo());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repo.getByName(s);
        if (user == null) {
            System.out.println("User not found! " + s);
            throw new UsernameNotFoundException("User " + s + " is not found");
        }
        return new AuthorizedUser(user);
    }

}
