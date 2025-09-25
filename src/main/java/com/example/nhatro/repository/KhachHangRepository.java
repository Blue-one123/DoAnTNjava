package com.example.nhatro.repository;

import com.example.nhatro.entity.KhachHang;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    
Optional<KhachHang> findByTenKhachHang(String tenKhachHang);
    
}
