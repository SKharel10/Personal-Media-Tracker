package com.example.personalmediatracker.repository;

import com.example.personalmediatracker.model.MediaItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaItemRepository extends JpaRepository<MediaItem, Long> {}
