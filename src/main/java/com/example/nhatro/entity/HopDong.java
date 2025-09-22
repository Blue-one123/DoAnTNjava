/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.nhatro.entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hop_dong")
public class HopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Gắn khách hàng
    @ManyToOne
    @JoinColumn(name = "khach_hang_id", nullable = false)
    private KhachHang khachHang;

    // Gắn phòng
    @ManyToOne
    @JoinColumn(name = "phong_id", nullable = false)
    private Phong phong;

    @Column(name = "ngay_bat_dau", nullable = false)
    private LocalDate ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private LocalDate ngayKetThuc;

    @Column(name = "tien_dat_coc")
    private Double tienDatCoc;

    @Column(name = "gia_thue")
    private Double giaThue;

    @Column(name = "trang_thai")
    private String trangThai; // Đang hiệu lực / Hết hạn / Hủy

    @Column(name = "phuong_thuc_thanh_toan")
    private String phuongThucThanhToan; // Tiền mặt / CK

    @Column(name = "ghi_chu")
    private String ghiChu;

    // Getter, Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Phong getPhong() {
        return phong;
    }
    public void setPhong(Phong phong) {
        this.phong = phong;
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
