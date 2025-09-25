package com.example.nhatro.dto;

import java.time.LocalDate;

public class HoaDonDTO {
    private Long id;
    private String maHoaDon;

    private Long khachHangId;
    private String tenKhachHang;
    private String soDienThoai;

    private Long phongId;
    private String maPhong;
    private Double giaPhong;

    private LocalDate ngayTao;
    private Double tienPhong;
    private Integer soDien;
    private Double donGiaDien;
    private Integer soNuoc;
    private Double donGiaNuoc;
    private Double dichVuKhac;
    private Double tongTien;
    private String trangThai;
    private String ghiChu;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public Long getKhachHangId() { return khachHangId; }
    public void setKhachHangId(Long khachHangId) { this.khachHangId = khachHangId; }

    public String getTenKhachHang() { return tenKhachHang; }
    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public Long getPhongId() { return phongId; }
    public void setPhongId(Long phongId) { this.phongId = phongId; }

    public String getMaPhong() { return maPhong; }
    public void setMaPhong(String maPhong) { this.maPhong = maPhong; }

    public Double getGiaPhong() { return giaPhong; }
    public void setGiaPhong(Double giaPhong) { this.giaPhong = giaPhong; }

    public LocalDate getNgayTao() { return ngayTao; }
    public void setNgayTao(LocalDate ngayTao) { this.ngayTao = ngayTao; }

    public Double getTienPhong() { return tienPhong; }
    public void setTienPhong(Double tienPhong) { this.tienPhong = tienPhong; }

    public Integer getSoDien() { return soDien; }
    public void setSoDien(Integer soDien) { this.soDien = soDien; }

    public Double getDonGiaDien() { return donGiaDien; }
    public void setDonGiaDien(Double donGiaDien) { this.donGiaDien = donGiaDien; }

    public Integer getSoNuoc() { return soNuoc; }
    public void setSoNuoc(Integer soNuoc) { this.soNuoc = soNuoc; }

    public Double getDonGiaNuoc() { return donGiaNuoc; }
    public void setDonGiaNuoc(Double donGiaNuoc) { this.donGiaNuoc = donGiaNuoc; }

    public Double getDichVuKhac() { return dichVuKhac; }
    public void setDichVuKhac(Double dichVuKhac) { this.dichVuKhac = dichVuKhac; }

    public Double getTongTien() { return tongTien; }
    public void setTongTien(Double tongTien) { this.tongTien = tongTien; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}
