package com.example.nhatro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "khach_hang")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_khach_hang", nullable = false)
    private String tenKhachHang;

    @Column(name = "so_dien_thoai", nullable = false, unique = true)
    private String soDienThoai;

    @Column(name = "ngay_sinh", nullable = false)
    private String ngaySinh;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "email")
    private String email;

    @Column(name = "cccd")
    private String cccd;
    
    @ManyToOne
    @JoinColumn(name = "phong_id") // Khóa ngoại trong bảng khach_hang
    private Phong phong;
    
    @OneToOne
    @JoinColumn(name = "hop_dong_id" ) // Khóa ngoại trong bảng khach_hang
    private HopDong hopDong;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTenKhachHang() { return tenKhachHang; }
    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }
    
    public Phong getPhong() { return phong; }
    public void setPhong(Phong phong) { this.phong = phong; }

    public HopDong getHopDong() { return hopDong; }
    public void setHopDong(HopDong hopDong) { this.hopDong = hopDong; }   
    

}
