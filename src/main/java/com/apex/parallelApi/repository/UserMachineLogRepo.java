package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.UserMachineLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMachineLogRepo extends JpaRepository<UserMachineLog, Long> {
}
