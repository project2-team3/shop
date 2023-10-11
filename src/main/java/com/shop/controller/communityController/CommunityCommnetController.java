package com.shop.controller.communityController;


import com.shop.dto.communityDto.commentDto.CommentReadResponse;
import com.shop.service.communityService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityCommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentReadResponse> findByComment(@RequestParam(value = "q")final String comment){
        return commentService.
    }

}
