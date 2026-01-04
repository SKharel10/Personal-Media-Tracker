package com.example.personalmediatracker.dto;

import com.example.personalmediatracker.model.MediaType;

public record CreateMediaItemRequest(
        String title,
        MediaType mediaType,
        Integer totalUnits
) {
}
