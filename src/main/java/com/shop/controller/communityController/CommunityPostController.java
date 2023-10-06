package com.shop.controller.communityController;

import com.shop.dto.communityDto.PostCreateRequest;
import com.shop.dto.communityDto.PostReadResponse;
import com.shop.dto.communityDto.PostUpdateRequest;
import com.shop.repository.communityRepository.PostRepository;
import com.shop.service.communityService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gall")
public class CommunityPostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/")
    public List<PostReadResponse> AllPost(){
        return postService.getAll();
    }

    @PostMapping("/write")
    public Long createPost(@RequestBody PostCreateRequest c){
        return postService.create(c);
    }

    @PutMapping("/update")
    public Long updatePost(@RequestBody PostUpdateRequest u){
        return postService.update(u);
    }

    @DeleteMapping("/del/{postId}")
    public Long deletePost(@PathVariable(value = "postId") Long postId){
        return postService.delete(postId);
    }

}
