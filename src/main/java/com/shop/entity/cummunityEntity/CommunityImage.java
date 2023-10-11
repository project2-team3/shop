package com.shop.entity.cummunityEntity;


import javax.persistence.*;

@Entity
@Table(name = "image")
public class CommunityImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postNumber;

    @Column
    private String imageSrc;

    public CommunityImage() {
    }

    public CommunityImage(Long id, Long postNumber, String imageSrc) {
        this.id = id;
        this.postNumber = postNumber;
        this.imageSrc = imageSrc;
    }
}