package com.example.personalmediatracker.model;

import jakarta.persistence.*;

@Entity
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private MediaType mediaType;
    private Integer totalUnits; // Example: 900 pages for a book, 10 episodes for a TV show.
    @Enumerated(EnumType.STRING)
    private ProgressStatus progressStatus;
    private Integer progress;
    public MediaItem() {
    }

    public MediaItem(Long id, String title, MediaType mediaType, Integer totalUnits, ProgressStatus progressStatus, Integer progress) {
        this.id = id;
        this.title = title;
        this.mediaType = mediaType;
        this.totalUnits = totalUnits;
        this.progressStatus = progressStatus;
        this.progress = progress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Integer totalUnits) {
        this.totalUnits = totalUnits;
    }

    public ProgressStatus getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProgressStatus progressStatus) {
        this.progressStatus = progressStatus;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}
