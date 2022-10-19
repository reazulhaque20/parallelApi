package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Clouds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudsRepo extends JpaRepository<Clouds, Integer> {
}
