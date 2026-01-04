package com.example.personalmediatracker.controller;

import com.example.personalmediatracker.dto.CreateMediaItemRequest;
import com.example.personalmediatracker.dto.MediaItemDTO;
import com.example.personalmediatracker.dto.UpdateMediaItemRequest;
import com.example.personalmediatracker.dto.UpdateProgressRequest;
import com.example.personalmediatracker.model.MediaItem;
import com.example.personalmediatracker.service.MediaItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaItemController {
    private final MediaItemService mediaItemService;

    public MediaItemController(MediaItemService mediaItemService) {
        this.mediaItemService = mediaItemService;
    }

    @GetMapping
    public List<MediaItemDTO> getAllMediaItems(){
        return mediaItemService.getAllMediaItems();
    }

    @GetMapping({"id"})
    public MediaItemDTO getMediaItemById(@PathVariable Long id){
        return mediaItemService.getMediaItemById(id);
    }

    @PostMapping
    public void createMediaItem(@Valid @RequestBody CreateMediaItemRequest request){
        MediaItem mediaItem = mediaItemService.create(request);
    }

    @PutMapping("{id}")
    public void updateMediaItem(@PathVariable Long id, @RequestBody UpdateMediaItemRequest request){
        MediaItem updatedMediaItem = mediaItemService.updateMediaItem(id, request);
    }

    @PutMapping("/progress/{id}")
    public void updateProgress(@PathVariable Long id, @RequestBody UpdateProgressRequest request){
        MediaItem updatedMediaItem = mediaItemService.updateProgress(id, request);
    }


    @DeleteMapping("{id}")
    public void deleteMediaItemById(@PathVariable Long id){
        mediaItemService.deleteMediaItemById(id);
    }
}
