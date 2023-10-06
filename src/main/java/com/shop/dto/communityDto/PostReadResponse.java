package com.shop.dto.communityDto;

import com.shop.entity.cummunityEntity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PostReadResponse {

    private Long id;
    private String title;
    private String content;
    private Long memberId;
    private LocalDateTime dataTime;
    private Long like;
    private Long views;

    public static PostReadResponse fromEntity(Post p){
        return new PostReadResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getMemberId(),
                p.getDateTime(),
                p.getLike(),
                p.getViews()
        );
    }

    public PostReadResponse() {
    }

    public PostReadResponse(Long id, String title, String content, Long memberId, LocalDateTime dataTime, Long like, Long views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.dataTime = dataTime;
        this.like = like;
        this.views = views;
    }
}
