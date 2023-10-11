package com.shop.service.communityService;

import com.shop.entity.cummunityEntity.Comment;
import com.shop.entity.cummunityEntity.Post;
import com.shop.repository.MemberRepository;
import com.shop.repository.communityRepository.CommentRepository;
import com.shop.repository.communityRepository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;


    @Autowired
    private MemberRepository memberRepository;

    public List<Post> findByComment(final String communityComment){
        List<Comment> comments = commentRepository.findByCommentContentContaining(communityComment);
        List<Long> postNumbers = comments.stream()
                .map(Comment :: getPostNumber)
                .toList();
        List<Post> posts = postRepository.findByIdIn(postNumbers);
        return posts;
    }

}
