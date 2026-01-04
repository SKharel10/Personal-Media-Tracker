package com.example.personalmediatracker.service;


import com.example.personalmediatracker.model.MediaItem;
import com.example.personalmediatracker.repository.MediaItemRepository;

import java.util.List;

public class MediaItemService {
    private final MediaItemRepository mediaItemRepository;

    public MediaItemService(MediaItemRepository mediaItemRepository) {
        this.mediaItemRepository = mediaItemRepository;
    }

    public List<MediaItem> getMediaItems(){
        return mediaItemRepository.findAll();
    }
    public MediaItem getMediaItem(Long id){
        return mediaItemRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException(id + "not found"));
    }
}
