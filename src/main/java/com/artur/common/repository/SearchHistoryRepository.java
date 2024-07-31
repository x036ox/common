package com.artur.common.repository;

import com.artur.common.entity.SearchHistory;
import org.springframework.data.repository.ListCrudRepository;

public interface SearchHistoryRepository extends ListCrudRepository<SearchHistory, Long> {
}
