package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.MachineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineDetailsRepo extends JpaRepository<MachineDetails, Long> {

    List<MachineDetails> findAllByStatus(String status);
}
