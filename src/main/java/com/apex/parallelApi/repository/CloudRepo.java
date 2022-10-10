package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Cloud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudRepo extends JpaRepository<Cloud, Integer> {
}
