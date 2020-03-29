package ru.FogStreamBackEnd.FSBe;

import ru.FogStreamBackEnd.FSBe.model.Role;
import ru.FogStreamBackEnd.FSBe.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

import static ru.FogStreamBackEnd.FSBe.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {

    public static final int USER_ID = START_SEQ;
    public static final User USER = new User(USER_ID,"Surname", "User","Patronymic", LocalDate.now(),null,"м", LocalDateTime.now(), "password",true, Collections.singleton(Role.ROLE_USER));
}
