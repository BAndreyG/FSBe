package ru.forStreamBackEnd.FSBe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity (name = "categorys")
public class Category extends AbstractBaseEntity {

    @Column(name = "name",nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorys")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JsonIgnore
    protected List<News> newsList;*/

    public Category (){}

    public Category(@NotBlank @Size(min = 2, max = 100) String name) {
        this.name = name;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "category")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    @JoinTable(
            name = "user_category",
            joinColumns = { @JoinColumn(name = "category_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    List<User> users;

    /*public Category(@NotBlank @Size(min = 2, max = 100) String name, List<News> newsList) {
        this.name = name;
        this.newsList = newsList;
    }*/

    public Category(Integer id, @NotBlank @Size(min = 2, max = 100) String name,List<User> users) {
        super(id);
        this.name = name;
        this.users=users;
    }
    /*public Category(Integer id, @NotBlank @Size(min = 2, max = 100) String name, List<News> newsList) {
        super(id);
        this.name = name;
        this.newsList = newsList;
    }*/
}
