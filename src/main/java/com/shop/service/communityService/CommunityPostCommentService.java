package com.shop.service.communityService;

import com.shop.entity.cummunityEntity.CommunityPost;
import com.shop.entity.cummunityEntity.CommunityPostComment;
import com.shop.repository.MemberRepository;
import com.shop.repository.communityRepository.CommunityPostCommentRepository;
import com.shop.repository.communityRepository.CommunityPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityPostCommentService {

    @Autowired
    private CommunityPostCommentRepository communityPostCommentRepository;

    @Autowired
    private CommunityPostRepository communityPostRepository;


    @Autowired
    private MemberRepository memberRepository;

    public List<CommunityPost> findByComment(final String communityComment){
        List<CommunityPostComment> communityPostComments = communityPostCommentRepository.findByCommentContentContaining(communityComment);
        List<Long> postNumbers = communityPostComments.stream()
                .map(CommunityPostComment:: getPostNumber)
                .toList();
        List<CommunityPost> communityPosts = communityPostRepository.findByIdIn(postNumbers);
        return communityPosts;
    }

}
