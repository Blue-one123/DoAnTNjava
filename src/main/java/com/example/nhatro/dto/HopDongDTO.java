package com.example.nhatro.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HopDongDTO {
    private Long id;
    private String maHopDong;       // mã hợp đồng
    private Long khachHangId;
    private String tenKhachHang;    // hiển thị
    private Long phongId;
    private String maPhong;         // hiển thị
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private Double soTienCoc;
    private Double soTienThue;      // giá phòng copy từ bảng phong
    private String fileHopDong;     // đường dẫn file
    private String trangThai;       // ChoDuyet / DangHieuLuc / HetHan / Huy
    private String ghiChu;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getter & Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMaHopDong() {
        return maHopDong;
    }
    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public Long getKhachHangId() {
        return khachHangId;
    }
    public void setKhachHangId(Long khachHangId) {
        this.khachHangId = khachHangId;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }
    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Long getPhongId() {
        return phongId;
    }
    public void setPhongId(Long phongId) {
        this.phongId = phongId;
    }

    public String getMaPhong() {
        return maPhong;
    }
    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Double getSoTienCoc() {
        return soTienCoc;
    }
    public void setSoTienCoc(Double soTienCoc) {
        this.soTienCoc = soTienCoc;
    }

    public Double getSoTienThue() {
        return soTienThue;
    }
    public void setSoTienThue(Double soTienThue) {
        this.soTienThue = soTienThue;
    }

    public String getFileHopDong() {
        return fileHopDong;
    }
    public void setFileHopDong(String fileHopDong) {
        this.fileHopDong = fileHopDong;
    }

    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
