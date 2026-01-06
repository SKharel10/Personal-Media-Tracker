package com.example.personalmediatracker.controller;

import com.example.personalmediatracker.dto.CreateMediaItemRequest;
import com.example.personalmediatracker.service.MediaItemService;
import jakarta.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/media")
public class MediaViewController {

    private final MediaItemService mediaItemService;

    public MediaViewController(MediaItemService mediaItemService) {
        this.mediaItemService = mediaItemService;
    }
    @GetMapping
    public String getAllMedia(Model model){
        model.addAttribute("mediaItems", mediaItemService.getAllMediaItems());
        return "fragments/media-list";
    }
    @PostMapping
    public String create(CreateMediaItemRequest request, Model model, ServletRequest servletRequest){
        mediaItemService.create(request);
        model.addAttribute("mediaItems", mediaItemService.getAllMediaItems());
        return "fragments/media-list";
    }

}
