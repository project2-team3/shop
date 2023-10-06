package com.shop.dto.communityDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PostCreateRequest {

    private String title;
    private String content;
    private Long memberId;
    private LocalDateTime dateTime;
    private Long like;
    private Long views;

}
