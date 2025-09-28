package com.example.nhatro.repository;

import com.example.nhatro.entity.HopDong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HopDongRepository extends JpaRepository<HopDong, Long> {
    Page<HopDong> findByTenKhachHangContainingIgnoreCase(String tenKhachHang, Pageable pageable);

    // nếu cần thêm tìm theo mã phòng
    Page<HopDong> findByMaPhongContainingIgnoreCase(String maPhong, Pageable pageable);
}
