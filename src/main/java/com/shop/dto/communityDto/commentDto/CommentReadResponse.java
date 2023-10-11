package com.shop.dto.communityDto.commentDto;

import com.shop.entity.cummunityEntity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentReadResponse {

    private Long id;
    private Long postId;
    private String userName;
    private String commentContent;
    private LocalDateTime dateTime;
    private Post post;

    public CommentReadResponse() {
    }

    public CommentReadResponse(Long id, Long postId, String userName, String commentContent, LocalDateTime dateTime, Post post) {
        this.id = id;
        this.postId = postId;
        this.userName = userName;
        this.commentContent = commentContent;
        this.dateTime = dateTime;
        this.post = post;
    }

    public CommentReadResponse(Long id, Long postId, String userName, String commentContent, LocalDateTime dateTime) {
        this.id = id;
        this.postId = postId;
        this.userName = userName;
        this.commentContent = commentContent;
        this.dateTime = dateTime;
    }
}
