package com.example.personalmediatracker.controller;

import com.example.personalmediatracker.model.MediaItem;
import com.example.personalmediatracker.service.MediaItemService;
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
    public List<MediaItem> getAllMediaItems(){
        return mediaItemService.getAllMediaItems();
    }
    @GetMapping({"id"})
    public MediaItem getMediaItemById(@PathVariable Long id){
        return mediaItemService.getMediaItemById(id);
    }
    @PostMapping()
    public void insertMediaItem(@RequestBody MediaItem mediaItem){
        mediaItemService.insertMediaItem(mediaItem);
    }
    @PutMapping("{id}")
    public void updateMediaItemById(@RequestBody MediaItem mediaItem, @PathVariable Long id){
        mediaItemService.updateMediaItemById(mediaItem, id);
    }
    @DeleteMapping("{id}")
    public void deleteMediaItemById(@PathVariable Long id){
        mediaItemService.deleteMediaItemById(id);
    }
}
