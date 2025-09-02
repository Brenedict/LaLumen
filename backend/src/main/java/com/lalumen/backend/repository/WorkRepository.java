package com.lalumen.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lalumen.backend.entity.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Integer> {
    @Query(value = "SELECT * FROM Work WHERE account_id = :accountId", nativeQuery = true)
    List<Work> findByAccountId(@Param("accountId") int accountId);
}
