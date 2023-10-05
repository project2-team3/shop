package com.shop.service.communityService;

import com.shop.dto.communityDto.PostReadResponse;
import com.shop.entity.cummunityEntity.Post;
import com.shop.repository.communityRepository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostReadResponse> getAll(){ // Post내 정보를 모두 불러 오는 함수
        return postRepository.findAll()
                .stream()
                .map(PostReadResponse::fromEntity)
                .collect(Collectors.toList());
    }

}
