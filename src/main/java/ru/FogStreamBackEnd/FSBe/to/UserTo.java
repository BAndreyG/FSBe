package ru.FogStreamBackEnd.FSBe.to;

import lombok.Data;
import ru.FogStreamBackEnd.FSBe.model.Category;
import ru.FogStreamBackEnd.FSBe.model.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static ru.FogStreamBackEnd.FSBe.model.Role.ROLE_USER;

@Data
public class UserTo extends BaseTo {

    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthday = LocalDate.now();
    private String foto;
    private String gender;
    private LocalDateTime registered = LocalDateTime.now();
    private String password;
    private boolean enabled = true;
    private Set<Role> roles;
    private String category;
    private List<Category> categories;

    public UserTo() {
    }

    public UserTo(String surname, String name, String patronymic, LocalDate birthday, String foto, String gender, LocalDateTime registered, String password, boolean enabled, String category) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.foto = foto;
        this.gender = gender;
        this.registered = registered;
        this.password = password;
        this.enabled = enabled;
        this.roles.add(ROLE_USER);
        this.category = category;
    }

    public UserTo(Integer id, String surname, String name, String patronymic, LocalDate birthday, String foto, String gender, LocalDateTime registered, String password, boolean enabled, Set<Role> roles, String category) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.foto = foto;
        this.gender = gender;
        this.registered = registered;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
        this.category = category;
    }
}
