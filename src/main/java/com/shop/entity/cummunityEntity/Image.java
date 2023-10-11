package com.shop.entity.cummunityEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postNumber;

    @Column(nullable = false)
    private String imageSrc;



}