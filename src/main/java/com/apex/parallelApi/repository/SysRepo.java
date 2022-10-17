package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Sys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface SysRepo extends JpaRepository<Sys, Long> {
}
