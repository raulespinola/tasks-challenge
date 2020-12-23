package com.spacex.trelloassistant.repository;

import com.spacex.trelloassistant.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
