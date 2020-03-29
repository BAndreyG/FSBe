package ru.FogStreamBackEnd.FSBe;


import org.springframework.security.core.userdetails.UserDetails;
import ru.FogStreamBackEnd.FSBe.model.User;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private User user;

    public AuthorizedUser(User user) {
        super(user.getName(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        this.user = user;
    }
    public User getUser() {
        return user;
    }

}