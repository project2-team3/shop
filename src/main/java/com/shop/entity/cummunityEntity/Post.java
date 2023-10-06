package com.shop.entity.cummunityEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
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
    private Long memberId;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private Long like;

    @Column(nullable = false)
    private Long views;

    public Post() {
    }

    public Post(String title, String content, Long memberId, LocalDateTime dateTime, Long like, Long views) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.dateTime = dateTime;
        this.like = like;
        this.views = views;
    }

    public Post(Long id, String title, String content, Long memberId, LocalDateTime dateTime, Long like, Long views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.dateTime = dateTime;
        this.like = like;
        this.views = views;
    }
}
