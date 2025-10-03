package com.example.nhatro.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "hop_dong")
public class HopDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_hop_dong", nullable = false, unique = true, length = 50)
    private String maHopDong;

    //Quan hệ với khách hàng
    @OneToOne
    @JoinColumn(name = "khach_hang_id", nullable = false)
    private KhachHang khachHang;


    // Quan hệ với phòng
    @OneToOne
    @JoinColumn(name = "phong_id", nullable = false)
    private Phong phong;
    
    @Column(name = "ten_khach_hang", nullable = false)
    private String tenKhachHang; 
    
   
    @Column(name = "ma_phong", nullable = false)
    private String maPhong;
    
    @Column(name = "ngay_bat_dau", nullable = false)
    private LocalDate ngayBatDau;

    @Column(name = "ngay_ket_thuc", nullable = false)
    private LocalDate ngayKetThuc;

    @Column(name = "so_tien_coc")
    private Double soTienCoc;

    @Column(name = "so_tien_thue",  nullable = false)
    private Double soTienThue;

    @Column(name = "file_hop_dong", length = 255)
    private String fileHopDong;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai", nullable = false)
    private TrangThaiHopDong trangThai = TrangThaiHopDong.ChoDuyet;

    @Column(name = "ghi_chu", columnDefinition = "TEXT")
    private String ghiChu;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Enum trạng thái hợp đồng
    public enum TrangThaiHopDong {
        ChoDuyet, DangHieuLuc, HetHan, Huy
    }

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
    
     public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
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

    public TrangThaiHopDong getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiHopDong trangThai) {
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
