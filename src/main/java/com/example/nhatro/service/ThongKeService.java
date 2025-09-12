/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.nhatro.service;



import java.util.List;
import java.util.Map;

public interface ThongKeService {
    Map<String, Double> doanhThuTheoThang(int year);
    List<String> danhSachPhongTheoTrangThai(String trangThai);
    Double chiPhiTrungBinhTheoThang(int month, int year);
    List<String> topKhachHangThueLau();
    List<String> danhSachNoTien();
}
