package com.artur.common.repository;

import com.artur.common.entity.user.UserMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMetadataRepository extends JpaRepository<UserMetadata, Long> {
}
