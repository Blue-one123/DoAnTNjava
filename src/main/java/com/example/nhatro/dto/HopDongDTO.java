package com.example.nhatro.dto;

import java.time.LocalDate;

public class HopDongDTO {
    private Long id;
    private Long khachHangId;
    private String tenKhachHang; // hiển thị
    private Long phongId;
    private String maPhong; // hiển thị
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private Double tienDatCoc;
    private Double giaThue;
    private String trangThai;
    private String phuongThucThanhToan;
    private String ghiChu;

    // Getter & Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public void setMaPhong(String tenPhong) {
        this.maPhong = tenPhong;
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

    public Double getTienDatCoc() {
        return tienDatCoc;
    }
    public void setTienDatCoc(Double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public Double getGiaThue() {
        return giaThue;
    }
    public void setGiaThue(Double giaThue) {
        this.giaThue = giaThue;
    }

    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }
    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
