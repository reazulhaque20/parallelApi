package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.UserMachineLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMachineLogRepo extends JpaRepository<UserMachineLog, Long> {
}
