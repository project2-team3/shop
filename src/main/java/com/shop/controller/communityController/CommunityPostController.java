package com.shop.controller.communityController;

import com.shop.dto.communityDto.PostCreateRequest;
import com.shop.dto.communityDto.PostReadResponse;
import com.shop.dto.communityDto.PostUpdateRequest;
import com.shop.entity.cummunityEntity.Post;
import com.shop.service.communityService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gall")
public class CommunityPostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public List<PostReadResponse> AllPost(){
        return postService.getAll();
    }

    @GetMapping("/title-page")
    public List<Post> findByTitle (@RequestParam(value = "q")final String title){
        return postService.findByTitle(title);
    }

    @GetMapping("/content-page")
    public List<Post> findByContent (@RequestParam(value = "q") final String content){
        return postService.findByContent(content);
    }

    @GetMapping("/member-page")
    public List<Post> findByName (@RequestParam(value = "q")final String name){
        return postService.findByName(name);
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
