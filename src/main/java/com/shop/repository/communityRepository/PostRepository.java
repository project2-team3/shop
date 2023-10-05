package com.shop.repository.communityRepository;

import com.shop.entity.cummunityEntity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleContaining(String s);
    List<Post> findByContentContaining(String s);
    List<Post> findByUserNameContaining(String s);
}
