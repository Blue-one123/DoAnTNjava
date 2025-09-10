package com.example.nhatro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.nhatro.entity.KhachHang;
import com.example.nhatro.service.KhachHangService;

import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangcontroller {

    @Autowired
    private KhachHangService khachHangService;

    // Lấy danh sách khách hàng
    @GetMapping
    public List<KhachHang> getAllKhachHang() {
        return khachHangService.getAllKhachHang();
    }

    // Thêm khách hàng mới
    @PostMapping
    public KhachHang addKhachHang(@RequestBody KhachHang khachHang) {
        return khachHangService.saveKhachHang(khachHang);
    }

    // Tìm khách hàng theo ID
    @GetMapping("/{id}")
    public KhachHang getKhachHangById(@PathVariable Long id) {
        return khachHangService.getKhachHangById(id);
    }

    // Xóa khách hàng
    @DeleteMapping("/{id}")
    public void deleteKhachHang(@PathVariable Long id) {
        khachHangService.deleteKhachHang(id);
    }
}   
