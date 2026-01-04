package com.example.personalmediatracker.dto;

import com.example.personalmediatracker.model.ProgressStatus;

public record MediaItemDTO(
        String title,
        ProgressStatus status,
        Integer progress,
        Integer totalUnits
){

}


