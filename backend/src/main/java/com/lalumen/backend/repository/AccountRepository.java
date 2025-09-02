package com.lalumen.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lalumen.backend.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT * FROM Account WHERE username = :username", nativeQuery = true)
    Account findByUsername(@Param("username") String username);
}
