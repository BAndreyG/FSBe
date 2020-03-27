package ru.FogStreamBackEnd.FSBe.util;

import ru.FogStreamBackEnd.FSBe.model.User;
import ru.FogStreamBackEnd.FSBe.to.UserTo;

import java.util.Base64;

public class UserUtil {
    public UserUtil (){}

    public static User convertUser(UserTo userTo,User user){
        user.setSurname(userTo.getSurname());
        user.setName(userTo.getName());
        user.setPatronymic(userTo.getPatronymic());
        user.setBirthday(userTo.getBirthday());
        user.setFoto(javax.xml.bind.DatatypeConverter.parseBase64Binary(userTo.getFoto().split(",")[1]));
        user.setGender(userTo.getGender());
        user.setPassword(userTo.getPassword());
//        user.setCategories();
        return user;
    }

    public static UserTo convertUserTo(User user,UserTo userTo){
        userTo.setSurname(user.getSurname());
        userTo.setId(user.getId());
        userTo.setName(user.getName());
        userTo.setPatronymic(user.getPatronymic());
        userTo.setBirthday(user.getBirthday());
        userTo.setFoto(new String(Base64.getEncoder().encode(user.getFoto())));
        userTo.setGender(user.getGender());
        userTo.setPassword(user.getPassword());
        userTo.setCategories(user.getCategories());
        return userTo;
    }
}
