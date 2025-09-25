package com.example.nhatro.controller;

import com.example.nhatro.dto.HoaDonDTO;

import com.example.nhatro.service.HoaDonService;
import com.example.nhatro.service.KhachHangService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoadon")
public class HoaDoncontroller {

    private final HoaDonService hoaDonService;
    private final KhachHangService khachHangService;

    public HoaDoncontroller(HoaDonService hoaDonService, KhachHangService khachHangService) {
        this.hoaDonService = hoaDonService;
        this.khachHangService = khachHangService;
    }

    // Thêm hóa đơn
    @PostMapping
    public ResponseEntity<HoaDonDTO> createHoaDon(@RequestBody HoaDonDTO hoaDonDTO) {
        return ResponseEntity.ok(hoaDonService.createHoaDon(hoaDonDTO));
    }

    // Sửa hóa đơn
    @PutMapping("/{id}")
    public ResponseEntity<HoaDonDTO> updateHoaDon(@PathVariable Long id, @RequestBody HoaDonDTO hoaDonDTO) {
        return ResponseEntity.ok(hoaDonService.updateHoaDon(id, hoaDonDTO));
    }

    // Xóa hóa đơn
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoaDon(@PathVariable Long id) {
        hoaDonService.deleteHoaDon(id);
        return ResponseEntity.noContent().build();
    }

    // Lấy 1 hóa đơn
    @GetMapping("/{id}")
    public ResponseEntity<HoaDonDTO> getHoaDonById(@PathVariable Long id) {
        return ResponseEntity.ok(hoaDonService.getHoaDonById(id));
    }

    // Lấy danh sách hóa đơn
    @GetMapping
    public ResponseEntity<List<HoaDonDTO>> getAllHoaDon() {
        return ResponseEntity.ok(hoaDonService.getAllHoaDon());
    }

    // API lấy danh sách khách hàng đang thuê phòng
   /* @GetMapping("/khachhang-thue")
    public ResponseEntity<List<KhachHangPhongDTO>> getKhachHangDangThue() {
        return ResponseEntity.ok(khachHangService.getKhachHangDangThue());
    }*/
}
