package com.example.nhatro.service;

import com.example.nhatro.entity.KhachHang;
import java.util.List;

public interface KhachHangService {
    List<KhachHang> getAllKhachHang();
    KhachHang getKhachHangById(Long id);
    KhachHang saveKhachHang(KhachHang khachHang);
    KhachHang updateKhachHang(Long id, KhachHang khachHang);
    void deleteKhachHang(Long id);
}
