package com.example.nhatro.repository;

import com.example.nhatro.entity.HoaDon;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

    public List<HoaDon> findByTrangThai(String chưa_thanh_toán);
}
