package ru.FogStreamBackEnd.FSBe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "news")
public class News extends AbstractBaseEntity{

    @Column(name = "head",nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String head;

    @Column(name = "mintext",nullable = false)
    @NotBlank
    @Size(min = 2, max = 200)
    private String mintext;

    @Column(name = "news",nullable = false)
    @NotBlank
    private String news;

    @Column(name = "preview")
    private String preview;

    @Column(name = "createday", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDateTime createday = LocalDateTime.now();

    @Column(name = "link",nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String link;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

//    @JoinTable(name = "categorys", joinColumns = @JoinColumn(name = "category_id"))
    @ManyToOne
    @JoinColumn(name = "category_id")
//    @Column(name = "name")
    private Category category;

    public News(){}

    public News(@NotBlank @Size(min = 2, max = 100) String head, @NotBlank @Size(min = 2, max = 200) String mintext, @NotBlank String news, String preview, @NotNull LocalDateTime createday, @NotBlank @Size(min = 2, max = 100) String link, boolean enabled,Category category) {
        this.head = head;
        this.mintext = mintext;
        this.news = news;
        this.preview = preview;
        this.createday = createday;
        this.link = link;
        this.enabled = enabled;
        this.category=category;
    }

    public News(Integer id, @NotBlank @Size(min = 2, max = 100) String head, @NotBlank @Size(min = 2, max = 200) String mintext, @NotBlank String news, String preview, @NotNull LocalDateTime createday, @NotBlank @Size(min = 2, max = 100) String link, boolean enabled,Category category) {
        super(id);
        this.head = head;
        this.mintext = mintext;
        this.news = news;
        this.preview = preview;
        this.createday = createday;
        this.link = link;
        this.enabled = enabled;
        this.category=category;
    }
}
