package com.artur.common.repository;

import com.artur.common.entity.VideoMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoMetadataRepository extends JpaRepository<VideoMetadata, Long> {
}
