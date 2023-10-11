package com.shop.dto.communityDto.imageDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommunityImageCreateRequest {
    private Long id;
    private Long postNumber;
    private String imageSrc;

    public CommunityImageCreateRequest() {
    }

    public CommunityImageCreateRequest(Long id, Long postNumber, String imageSrc) {
        this.id = id;
        this.postNumber = postNumber;
        this.imageSrc = imageSrc;
    }
}
