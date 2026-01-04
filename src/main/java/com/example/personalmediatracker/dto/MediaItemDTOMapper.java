package com.example.personalmediatracker.dto;
import com.example.personalmediatracker.model.MediaItem;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class MediaItemDTOMapper implements Function<MediaItem, MediaItemDTO> {

    @Override
    public MediaItemDTO apply(MediaItem mediaItem) {
        return new MediaItemDTO(
                mediaItem.getTitle(),
                mediaItem.getProgressStatus(),
                mediaItem.getProgress(),
                mediaItem.getTotalUnits());
    }

}
