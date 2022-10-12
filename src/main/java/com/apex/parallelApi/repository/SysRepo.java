package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Sys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRepo extends JpaRepository<Sys, Long> {
}
