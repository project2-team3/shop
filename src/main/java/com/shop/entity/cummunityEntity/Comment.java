package com.shop.entity.cummunityEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="commnet")
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
    private String content;

}
