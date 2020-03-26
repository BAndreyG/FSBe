package ru.forStreamBackEnd.FSBe.util;

import ru.forStreamBackEnd.FSBe.model.User;
import ru.forStreamBackEnd.FSBe.to.UserTo;

public class UserUtil {
    public UserUtil (){}

    public static User convertUser(UserTo userTo,User user){
        user.setSurname(userTo.getSurname());
        user.setName(userTo.getName());
        user.setPatronymic(userTo.getPatronymic());
        user.setBirthday(userTo.getBirthday());
        user.setFoto(userTo.getFoto());
        user.setGender(userTo.getGender());
        user.setPassword(userTo.getPassword());

//        user.setCategories();
        return user;
    }
}
