package com.shop.dto.communityDto;

import com.shop.entity.cummunityEntity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostReadResponse {

    private Long id;
    private String title;
    private String content;
    private String userName;
    private String dateTime;
    private Long views;

    public PostReadResponse() {
    }

    public PostReadResponse(Long id, String title, String content, String userName, String dateTime, Long views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.dateTime = dateTime;
        this.views = views;
    }

    public static  PostReadResponse fromEntity(Post post){
        return new PostReadResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getUserName(),
                post.getDateTime(),
                post.getViews()
        );
    }
}
