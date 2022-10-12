package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Wind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WindRepo extends JpaRepository<Wind, Integer> {
}
