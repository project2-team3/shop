package com.shop.service.communityService;

import com.shop.dto.communityDto.postDto.CommunityPostCreateRequest;
import com.shop.dto.communityDto.postDto.CommunityPostReadResponse;
import com.shop.dto.communityDto.postDto.CommunityPostUpdateRequest;
import com.shop.entity.Member;
import com.shop.entity.cummunityEntity.CommunityPost;
import com.shop.repository.MemberRepository;
import com.shop.repository.communityRepository.PostRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MemberRepository memberRepository;


    public List<CommunityPostReadResponse> getAll() { // Post내 정보를 모두 불러 오는 함수
        return postRepository.findAll()
                .stream()
                .map(CommunityPostReadResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public List<CommunityPost> findByTitle(final String title){
        return postRepository.findByTitleContaining(title);
    }

    public List<CommunityPost> findByContent(final String content){
        return postRepository.findByContentContaining(content);
    }

    public List<CommunityPost> findByName(final String name){
        Member member= memberRepository.findByname(name);
        if(member != null){
            Long memberId = member.getId();
            return postRepository.findByMemberId(memberId);
        }
        return Collections.emptyList();
    }

    public Long create(final CommunityPostCreateRequest c) {
        CommunityPost p = new CommunityPost(
                c.getTitle(),
                c.getContent(),
                c.getMemberId(),
                c.getDateTime(),
                c.getLike(),
                c.getViews());
        return postRepository.save(p).getId();
    }

    public Long update(final CommunityPostUpdateRequest u) {
        CommunityPost p = postRepository.getReferenceById(u.getId());
        p.setTitle(u.getTitle());
        p.setContent(u.getContent());
        p.setMemberId(u.getMemberId());
        p.setLike(u.getLike());
        p.setViews(u.getViews());
        return p.getId();
    }

    public Long delete(final Long postId) {
        Long memberId = (Long) request.getAttribute("id");
        CommunityPost p = postRepository.getReferenceById(postId);
        if (p.getMemberId() == memberId) {
            postRepository.delete(p);
        }
        return p.getId();
    }
}