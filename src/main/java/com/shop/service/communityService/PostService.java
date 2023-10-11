package com.shop.service.communityService;

import com.shop.dto.communityDto.postDto.PostCreateRequest;
import com.shop.dto.communityDto.postDto.PostReadResponse;
import com.shop.dto.communityDto.postDto.PostUpdateRequest;
import com.shop.entity.Member;
import com.shop.entity.cummunityEntity.Post;
import com.shop.repository.MemberRepository;
import com.shop.repository.communityRepository.PostRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MemberRepository memberRepository;


    public List<PostReadResponse> getAll() { // Post내 정보를 모두 불러 오는 함수
        return postRepository.findAll()
                .stream()
                .map(PostReadResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public List<Post> findByTitle(final String title){
        return postRepository.findByTitleContaining(title);
    }

    public List<Post> findByContent(final String content){
        return postRepository.findByContentContaining(content);
    }

    public List<Post> findByName(final String name){
        Member member= memberRepository.findByname(name);
        if(member != null){
            Long memberId = member.getId();
            return postRepository.findByMemberId(memberId);
        }
        return Collections.emptyList();
    }

    public Long create(final PostCreateRequest c) {
        Post p = new Post(
                c.getTitle(),
                c.getContent(),
                c.getMemberId(),
                c.getDateTime(),
                c.getLike(),
                c.getViews());
        return postRepository.save(p).getId();
    }

    public Long update(final PostUpdateRequest u) {
        Post p = postRepository.getReferenceById(u.getId());
        p.setTitle(u.getTitle());
        p.setContent(u.getContent());
        p.setMemberId(u.getMemberId());
        p.setLike(u.getLike());
        p.setViews(u.getViews());
        return p.getId();
    }

    public Long delete(final Long postId) {
        Long memberId = (Long) request.getAttribute("id");
        Post p = postRepository.getReferenceById(postId);
        if (p.getMemberId() == memberId) {
            postRepository.delete(p);
        }
        return p.getId();
    }
}