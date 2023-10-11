package com.shop.controller.communityController;

import com.shop.dto.communityDto.postDto.CommunityPostCreateRequest;
import com.shop.dto.communityDto.postDto.CommunityPostReadResponse;
import com.shop.dto.communityDto.postDto.CommunityPostUpdateRequest;
import com.shop.entity.cummunityEntity.CommunityPost;
import com.shop.service.communityService.CommunityPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gall")
public class CommunityPostController {

    @Autowired
    private CommunityPostService communityPostService;

    @GetMapping("/")
    public List<CommunityPostReadResponse> AllPost(){
        return communityPostService.getAll();
    }

    @GetMapping("/title-page")
    public List<CommunityPost> findByTitle (@RequestParam(value = "q")final String title){
        return communityPostService.findByTitle(title);
    }

    @GetMapping("/content-page")
    public List<CommunityPost> findByContent (@RequestParam(value = "q") final String content){
        return communityPostService.findByContent(content);
    }

    @GetMapping("/member-page")
    public List<CommunityPost> findByName (@RequestParam(value = "q")final String name){
        return communityPostService.findByName(name);
    }

    @PostMapping("/write")
    public Long createPost(@RequestBody CommunityPostCreateRequest c){
        return communityPostService.create(c);
    }

    @PutMapping("/update")
    public Long updatePost(@RequestBody CommunityPostUpdateRequest u){
        return communityPostService.update(u);
    }

    @DeleteMapping("/del/{postId}")
    public Long deletePost(@PathVariable(value = "postId") Long postId){
        return communityPostService.delete(postId);
    }

}
