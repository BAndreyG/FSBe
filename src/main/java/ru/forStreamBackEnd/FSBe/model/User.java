package ru.forStreamBackEnd.FSBe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "password", name = "users_unique_email_idx")})
public class User extends AbstractBaseEntity{

    @Column(name = "surname",nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String surname;

    @Column(name = "name",nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "patronymic")
    @Size(min = 2, max = 50)
    private String patronymic;

    @Column(name = "birthday", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDate birthday=LocalDate.now();

    @Column(name = "foto")
    private String foto;

    @Column(name = "gender",nullable = false)
    @NotBlank
    @Size(min = 1, max =1)
    private String gender;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDateTime registered = LocalDateTime.now();

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    private Set<Role> roles;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "user")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "users")
    private List<Category> categories;

    public User() {
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname=" + surname +
                ", name=" + name +
                ", patronymic=" + patronymic +
                ", bithday=" + birthday +
                ", gender=" + gender +
                ", registered=" + registered +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}