package com.shop.controller.communityController;


import com.shop.entity.cummunityEntity.CommunityPost;
import com.shop.service.communityService.CommunityPostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CommunityCommentController {

    @Autowired
    private CommunityPostCommentService communityPostCommentService;


    @GetMapping("/comment")
    public List<CommunityPost> findByComment(@RequestParam(value = "q")final String comment){
        return communityPostCommentService.findByComment(comment);
    }

}
