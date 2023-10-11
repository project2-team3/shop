package com.shop.dto.communityDto.imageDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageReadResponse {
    private Long id;
    private Long postNumber;
    private String imageSrc;

    public ImageReadResponse() {
    }

    public ImageReadResponse(Long id, Long postNumber, String imageSrc) {
        this.id = id;
        this.postNumber = postNumber;
        this.imageSrc = imageSrc;
    }
}
