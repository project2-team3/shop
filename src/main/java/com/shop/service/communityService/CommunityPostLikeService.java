package com.shop.service.communityService;

import com.shop.dto.communityDto.postLikeDto.CommunityPostLikeDto;
import com.shop.entity.cummunityEntity.CommunityPostLike;
import com.shop.repository.communityRepository.CommunityPostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityPostLikeService {
    @Autowired
    private CommunityPostLikeRepository communityPostLikeRepository;

    public List<CommunityPostLike> numberOfPostLike(long id){
        List<CommunityPostLike> postLikes = communityPostLikeRepository.findByPostNumber(id);
        return postLikes;
    }

    public Long createRemove(CommunityPostLikeDto c){
        CommunityPostLike like = new CommunityPostLike(
                c.getPostNumber(),
                c.getMemberNumber(),
                c.getLikeHeart()
        );
        Long memberId = c.getMemberNumber();
        List<Long> postLikes = communityPostLikeRepository.findByPostNumber(c.getPostNumber())
                .stream()
                .map(CommunityPostLike::getMemberNumber)
                .toList();
        if(postLikes.contains(memberId)){
            communityPostLikeRepository.delete(like);
        }
        else{
            communityPostLikeRepository.save(like);
        }
        return c.getId();
    }

    public Long create(final CommunityPostLikeDto c){
        CommunityPostLike like = new CommunityPostLike(
                c.getPostNumber(),
                c.getMemberNumber(),
                c.getLikeHeart()
        );
        return communityPostLikeRepository.save(like).getId();
    }

    public Long delete(final CommunityPostLikeDto d){
        CommunityPostLike like = new CommunityPostLike(
                d.getPostNumber(),
                d.getMemberNumber(),
                d.getLikeHeart()
        );
       communityPostLikeRepository.delete(like);
       return d.getId();
    }

}
