package com.shop.repository.communityRepository;

import com.shop.entity.cummunityEntity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String s);
    List<Post> findByContentContaining(String s);
    List<Post> findByMemberId(Long along );

    List<Post> findByIdIn(List<Long> ids);
}
