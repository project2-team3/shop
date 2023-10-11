package com.shop.entity.cummunityEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="comment")
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postNumber;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String commentContent;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    public Comment() {
    }

    public Comment(Long id, Long postNumber, String userName, String commentContent, LocalDateTime dateTime, Post post) {
        this.id = id;
        this.postNumber = postNumber;
        this.userName = userName;
        this.commentContent = commentContent;
        this.dateTime = dateTime;
        this.post = post;
    }
}
