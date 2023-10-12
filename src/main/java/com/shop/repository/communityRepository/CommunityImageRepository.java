package com.shop.repository.communityRepository;

import com.shop.entity.cummunityEntity.CommunityImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityImageRepository extends JpaRepository<CommunityImage, Long> {

    List<CommunityImage> findByPostNumber(Long aLong);

}
