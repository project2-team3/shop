package com.shop.dto.communityDto.postDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostUpdateRequest {

    private Long id;
    private String title;
    private String content;
    private Long memberId;
    private Long like;
    private Long views;

    public PostUpdateRequest() {
    }

    public PostUpdateRequest(Long id, String title, String content, Long memberId, Long like, Long views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.like = like;
        this.views = views;
    }
}
