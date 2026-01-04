package com.example.personalmediatracker.service;


import com.example.personalmediatracker.model.MediaItem;
import com.example.personalmediatracker.model.MediaType;
import com.example.personalmediatracker.repository.MediaItemRepository;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Media;
import java.util.List;
@Service
public class MediaItemService {
    private final MediaItemRepository mediaItemRepository;

    public MediaItemService(MediaItemRepository mediaItemRepository) {
        this.mediaItemRepository = mediaItemRepository;
    }

    public List<MediaItem> getAllMediaItems(){
        return mediaItemRepository.findAll();
    }
    public MediaItem getMediaItemById(Long id){
        return mediaItemRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException(id + "not found"));
    }
    public void insertMediaItem(MediaItem mediaItem){

        // checks
        if (mediaItem.getTotalUnits() < 0){
            throw new IllegalArgumentException("Total units must be greater than 0");
        }

        mediaItemRepository.save(mediaItem);
    }

    public void updateMediaItemById(MediaItem mediaItem, Long id){
        MediaItem selectedMediaItem = mediaItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "not found"));

        selectedMediaItem.setMediaType(mediaItem.getMediaType());
        selectedMediaItem.setProgressStatus(mediaItem.getProgressStatus());
        selectedMediaItem.setTotalUnits(mediaItem.getTotalUnits());

        mediaItemRepository.save(selectedMediaItem);
    }

    public void deleteMediaItemById(Long id){
        MediaItem selectedMediaItem = mediaItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "not found"));

        mediaItemRepository.delete(selectedMediaItem);
    }
}
