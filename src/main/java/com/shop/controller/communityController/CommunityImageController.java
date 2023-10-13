package com.shop.controller.communityController;

import com.shop.dto.communityDto.imageDto.CommunityImageCreateRequest;
import com.shop.service.communityService.CommunityImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class CommunityImageController {

    @Autowired
    private CommunityImageService communityImageService;

    @PostMapping("/img-write")
    public Long createImage(@RequestBody CommunityImageCreateRequest imgCreate){
        return communityImageService.create(imgCreate);
    }

    @GetMapping("/img-read")
    public Long ReadImage(@RequestParam("file")MultipartFile file, @RequestParam("PostNm")Long postNumber) throws IOException {
        return communityImageService.uploadImage(file, postNumber);
    }
}
