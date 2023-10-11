package com.shop.service.communityService;

import com.shop.entity.cummunityEntity.CommunityPost;
import com.shop.entity.cummunityEntity.CommunityPostComment;
import com.shop.repository.MemberRepository;
import com.shop.repository.communityRepository.CommentRepository;
import com.shop.repository.communityRepository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityPostCommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;


    @Autowired
    private MemberRepository memberRepository;

    public List<CommunityPost> findByComment(final String communityComment){
        List<CommunityPostComment> communityPostComments = commentRepository.findByCommentContentContaining(communityComment);
        List<Long> postNumbers = communityPostComments.stream()
                .map(CommunityPostComment:: getPostNumber)
                .toList();
        List<CommunityPost> communityPosts = postRepository.findByIdIn(postNumbers);
        return communityPosts;
    }

}
