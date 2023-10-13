package com.shop.repository.communityRepository;

import com.shop.entity.cummunityEntity.CommunityPostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityPostLikeRepository extends JpaRepository<CommunityPostLike, Long> {

    List<CommunityPostLike> findByPostNumber(long along);
}
