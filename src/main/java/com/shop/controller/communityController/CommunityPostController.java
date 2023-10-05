package com.shop.controller.communityController;

import com.shop.dto.communityDto.PostReadResponse;
import com.shop.repository.communityRepository.PostRepository;
import com.shop.service.communityService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gall")
public class CommunityPostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/post")
    public List<PostReadResponse> AllPost(){
        return postService.getAll();
    }


}
