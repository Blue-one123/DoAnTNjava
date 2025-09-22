
package com.example.nhatro.entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ma_hoa_don", unique = true, nullable = false)
    private String maHoaDon;

   
    // Liên kết phòng
    @ManyToOne
    @JoinColumn(name = "phong_id", nullable = false)
    private Phong phong;

    // Liên kết khách hàng
    @ManyToOne
    @JoinColumn(name = "khach_hang_id", nullable = false)
    private KhachHang khachHang;

    @Column(name = "ngay_tao", nullable = false)
    private LocalDate ngayTao;

    @Column(name = "tien_phong")
    private Double tienPhong;

    @Column(name = "so_dien")
    private Integer soDien;

    @Column(name = "don_gia_dien")
    private Double donGiaDien;

    @Column(name = "so_nuoc")
    private Integer soNuoc;

    @Column(name = "don_gia_nuoc")
    private Double donGiaNuoc;

    @Column(name = "dich_vu_khac")
    private Double dichVuKhac; // wifi, rác, vệ sinh…

    @Column(name = "tong_tien")
    private Double tongTien;

    @Column(name = "trang_thai")
    private String trangThai; // Chưa thanh toán / Đã thanh toán

    @Column(name = "ghi_chu")
    private String ghiChu;

    // Tính tổng tiền trước khi lưu
    @PrePersist
    @PreUpdate
    public void tinhTongTien() {
        double tienDien = (soDien != null && donGiaDien != null) ? soDien * donGiaDien : 0;
        double tienNuoc = (soNuoc != null && donGiaNuoc != null) ? soNuoc * donGiaNuoc : 0;
        double dvKhac = (dichVuKhac != null) ? dichVuKhac : 0;
        double phong = (tienPhong != null) ? tienPhong : 0;

        this.tongTien = phong + tienDien + tienNuoc + dvKhac;
    }

    //Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
   
    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public Phong getPhong() { return phong; }
    public void setPhong(Phong phong) { this.phong = phong; }

    public KhachHang getKhachHang() { return khachHang; }
    public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; }

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
