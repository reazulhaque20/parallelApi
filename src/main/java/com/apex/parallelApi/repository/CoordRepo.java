package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Coord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CoordRepo extends JpaRepository<Coord, Long> {
}
