package com.shop.service.communityService;

import com.shop.dto.communityDto.postDto.CommunityPostCreateRequest;
import com.shop.dto.communityDto.postDto.CommunityPostReadResponse;
import com.shop.dto.communityDto.postDto.CommunityPostUpdateRequest;
import com.shop.entity.Member;
import com.shop.entity.cummunityEntity.CommunityPost;
import com.shop.repository.MemberRepository;
import com.shop.repository.communityRepository.CommunityPostRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityPostService {

    @Autowired
    private CommunityPostRepository communityPostRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MemberRepository memberRepository;


    public List<CommunityPostReadResponse> getAll() { // Post내 정보를 모두 불러 오는 함수
        return communityPostRepository.findAll()
                .stream()
                .map(CommunityPostReadResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public List<CommunityPost> findByTitle(final String title){
        return communityPostRepository.findByTitleContaining(title);
    }

    public List<CommunityPost> findByContent(final String content){
        return communityPostRepository.findByContentContaining(content);
    }

    public List<CommunityPost> findByName(final String name){
        Member member= memberRepository.findByname(name);
        if(member != null){
            Long memberId = member.getId();
            return communityPostRepository.findByMemberId(memberId);
        }
        return Collections.emptyList();
    }

    public Long create(final CommunityPostCreateRequest c) {
        CommunityPost p = new CommunityPost(
                c.getTitle(),
                c.getContent(),
                c.getMemberId(),
                c.getDateTime(),
                c.getLikeHeart(),
                c.getViews());
        return communityPostRepository.save(p).getId();
    }

    public Long update(final CommunityPostUpdateRequest u) {
        CommunityPost p = communityPostRepository.getReferenceById(u.getId());
        p.setTitle(u.getTitle());
        p.setContent(u.getContent());
        p.setMemberId(u.getMemberId());
        p.setLikeHeart(u.getLikeHeart());
        p.setViews(u.getViews());
        return p.getId();
    }

    public Long delete(final Long postId) {
        Long memberId = (Long) request.getAttribute("id");
        CommunityPost p = communityPostRepository.getReferenceById(postId);
        if (p.getMemberId() == memberId) {
            communityPostRepository.delete(p);
        }
        return p.getId();
    }
}