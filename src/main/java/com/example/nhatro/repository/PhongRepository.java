
package com.example.nhatro.repository;

import com.example.nhatro.entity.Phong;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhongRepository extends JpaRepository<Phong, Long> {
    List<Phong> findByLoaiPhongContainingIgnoreCase(String loaiPhong);
    
    List<Phong> findByTrangThai(String trangThai);
    Page<Phong> findByLoaiPhongContainingIgnoreCase(String loaiPhong, Pageable pageable);
}
