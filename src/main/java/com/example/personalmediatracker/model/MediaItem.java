package com.example.personalmediatracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private MediaType mediaType;
    private Long totalUnits; // Example: 900 pages for a book, 10 episodes for a TV show.
    private ProgressStatus progressStatus;

    public MediaItem() {
    }

    public MediaItem(Long id, MediaType mediaType, Long totalUnits, ProgressStatus progressStatus) {
        this.id = id;
        this.mediaType = mediaType;
        this.totalUnits = totalUnits;
        this.progressStatus = progressStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Long getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Long totalUnits) {
        this.totalUnits = totalUnits;
    }

    public ProgressStatus getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProgressStatus progressStatus) {
        this.progressStatus = progressStatus;
    }
}
