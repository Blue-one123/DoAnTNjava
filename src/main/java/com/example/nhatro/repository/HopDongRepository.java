package com.example.nhatro.repository;

import com.example.nhatro.entity.HopDong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HopDongRepository extends JpaRepository<HopDong, Long> {
    Page<HopDong> findByKhachHang_TenContainingIgnoreCase(String keyword, Pageable pageable);
}
