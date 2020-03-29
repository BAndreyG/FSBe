package ru.FogStreamBackEnd.FSBe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "categorys")
public class Category extends AbstractBaseEntity {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    @JoinTable(
            name = "user_category",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    List<User> users;
    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    public Category() {
    }

    public Category(@NotBlank @Size(min = 2, max = 100) String name) {
        this.name = name;
    }

    public Category(Integer id, @NotBlank @Size(min = 2, max = 100) String name, List<User> users) {
        super(id);
        this.name = name;
        this.users = users;
    }

    public Category(int categoryId, String name) {
        this.id=categoryId;
        this.name=name;
    }
}
