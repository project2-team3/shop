package com.shop.controller.communityController;

import com.shop.dto.communityDto.postLikeDto.CommunityPostLikeDto;
import com.shop.service.communityService.CommunityPostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like-heart")
public class CommunityPostLikeController {
    @Autowired
    private CommunityPostLikeService communityPostLikeService;

    @GetMapping
    public Integer numberOfLikeFind(@RequestParam(value = "q")Long id){
        return communityPostLikeService.numberOfPostLike(id).size();
    }
    @PostMapping("/likey")
    public Long createRemovePostLike (@RequestBody CommunityPostLikeDto heart){
        return communityPostLikeService.createRemove(heart);
    }
}
