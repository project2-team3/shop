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

    @Column
    private String imageSrc;

    public Image() {
    }

    public Image(Long id, Long postNumber, String imageSrc) {
        this.id = id;
        this.postNumber = postNumber;
        this.imageSrc = imageSrc;
    }
}