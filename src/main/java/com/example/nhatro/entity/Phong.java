package com.example.nhatro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "phong")
public class Phong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String maPhong;


    private String loaiPhong;

    private Double giaPhong;

    private String trangThai; // "Trống" hoặc "Đang thuê"

    @Column(length = 500)
    private String moTa;

    // getter & setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getMaPhong() { return maPhong; }
    public void setMaPhong(String maPhong) { this.maPhong = maPhong; }

    public String getLoaiPhong() { return loaiPhong; }
    public void setLoaiPhong(String loaiPhong) { this.loaiPhong = loaiPhong; }

    public Double getGiaPhong() { return giaPhong; }
    public void setGiaPhong(Double giaPhong) { this.giaPhong = giaPhong; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
}
