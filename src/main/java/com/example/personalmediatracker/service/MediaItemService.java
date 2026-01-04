package com.example.personalmediatracker.service;


import com.example.personalmediatracker.dto.*;
import com.example.personalmediatracker.model.MediaItem;
import com.example.personalmediatracker.model.ProgressStatus;
import com.example.personalmediatracker.repository.MediaItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaItemService {
    private final MediaItemRepository mediaItemRepository;
    private final MediaItemDTOMapper mediaItemDTOMapper;

    public MediaItemService(MediaItemRepository mediaItemRepository, MediaItemDTOMapper mediaItemDTOMapper) {
        this.mediaItemRepository = mediaItemRepository;
        this.mediaItemDTOMapper = mediaItemDTOMapper;
    }

    public List<MediaItemDTO> getAllMediaItems(){
        return mediaItemRepository.findAll()
                .stream()
                .map(mediaItemDTOMapper)
                .collect(Collectors.toList());
    }

    public MediaItemDTO getMediaItemById(Long id){
        return mediaItemRepository.findById(id)
                .map(mediaItemDTOMapper)
                .orElseThrow( () -> new IllegalArgumentException(id + "not found"));
    }

    public MediaItem create(CreateMediaItemRequest request){
        MediaItem mediaItem = new MediaItem(
                null,
                request.title(),
                request.mediaType(),
                request.totalUnits(),
                ProgressStatus.NOT_STARTED,
                0
        );
        return mediaItemRepository.save(mediaItem);
    }

    public MediaItem updateProgress(Long id, UpdateProgressRequest request){

        MediaItem selectedMediaItem = mediaItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "not found"));
        selectedMediaItem.setProgress(request.progress());
        return mediaItemRepository.save(selectedMediaItem);
    }

    public MediaItem updateMediaItem(Long id, UpdateMediaItemRequest request){
        MediaItem selectedMediaItem = mediaItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "not found"));

        selectedMediaItem.setTitle(request.title());
        selectedMediaItem.setTotalUnits(request.totalUnits());
        return mediaItemRepository.save(selectedMediaItem);
    }

    public void deleteMediaItemById(Long id){
        MediaItem selectedMediaItem = mediaItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "not found"));

        mediaItemRepository.delete(selectedMediaItem);
    }
}
