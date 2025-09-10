package com.example.nhatro.repository;

import com.example.nhatro.entity.KhachHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
}
