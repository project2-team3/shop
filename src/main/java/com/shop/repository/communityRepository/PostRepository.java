package com.shop.repository.communityRepository;

import com.shop.entity.cummunityEntity.CommunityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<CommunityPost, Long> {
    List<CommunityPost> findByTitleContaining(String s);
    List<CommunityPost> findByContentContaining(String s);
    List<CommunityPost> findByMemberId(Long along );

    List<CommunityPost> findByIdIn(List<Long> ids);
}
