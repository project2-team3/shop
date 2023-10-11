package com.shop.repository.communityRepository;

import com.shop.entity.cummunityEntity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByCommentContentContaining(String s);

}
