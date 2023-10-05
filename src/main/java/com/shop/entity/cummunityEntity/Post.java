package com.shop.entity.cummunityEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="post")
@Getter
@Setter
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String DateTime;

    @Column(nullable = false)
    private Long views;

    public Post() {
    }

    public Post(Long id, String title, String content, String userName, String dateTime, Long views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
        DateTime = dateTime;
        this.views = views;
    }

    public Post(String title, String content, String userName, String dateTime, Long views) {
        this.title = title;
        this.content = content;
        this.userName = userName;
        DateTime = dateTime;
        this.views = views;
    }
}