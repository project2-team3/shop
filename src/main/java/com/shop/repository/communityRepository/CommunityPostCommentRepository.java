package com.shop.repository.communityRepository;

import com.shop.entity.cummunityEntity.CommunityPostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityPostCommentRepository extends JpaRepository<CommunityPostComment, Long> {

    List<CommunityPostComment> findByCommentContentContaining(String s);

}
