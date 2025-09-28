package com.example.nhatro.repository;

import com.example.nhatro.entity.TienCoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TienCocRepository extends JpaRepository<TienCoc, Long> {
}
