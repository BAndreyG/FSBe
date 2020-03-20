package ru.forStreamBackEnd.FSBe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    public News(){}

    public News(@NotBlank @Size(min = 2, max = 100) String head, @NotBlank @Size(min = 2, max = 200) String mintext, @NotBlank String news, String preview, @NotNull LocalDateTime createday, @NotBlank @Size(min = 2, max = 100) String link, boolean enabled) {
        this.head = head;
        this.mintext = mintext;
        this.news = news;
        this.preview = preview;
        this.createday = createday;
        this.link = link;
        this.enabled = enabled;
    }

    public News(Integer id, @NotBlank @Size(min = 2, max = 100) String head, @NotBlank @Size(min = 2, max = 200) String mintext, @NotBlank String news, String preview, @NotNull LocalDateTime createday, @NotBlank @Size(min = 2, max = 100) String link, boolean enabled) {
        super(id);
        this.head = head;
        this.mintext = mintext;
        this.news = news;
        this.preview = preview;
        this.createday = createday;
        this.link = link;
        this.enabled = enabled;
    }
}
