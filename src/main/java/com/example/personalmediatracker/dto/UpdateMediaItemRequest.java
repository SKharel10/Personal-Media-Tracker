package com.example.personalmediatracker.dto;
import com.example.personalmediatracker.model.ProgressStatus;

public record UpdateMediaItemRequest(
        String title,
        Integer totalUnits
) {
}
