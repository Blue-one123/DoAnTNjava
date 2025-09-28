package com.example.nhatro.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tien_coc")
public class TienCoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Liên kết với hợp đồng
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hop_dong_id", nullable = false)
    private HopDong hopDong;

    @Column(name = "so_tien_coc", nullable = false)
    private Double soTienCoc;  // Lấy từ hop_dong.so_tien_coc

    @Column(name = "so_tien_hoan_tra")
    private Double soTienHoanTra;

    @Column(name = "ly_do_khau_tru")
    private String lyDoKhauTru;

    @Column(name = "ngay_hoan_tra")
    private LocalDate ngayHoanTra;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public HopDong getHopDong() { return hopDong; }
    public void setHopDong(HopDong hopDong) { this.hopDong = hopDong; }

    public Double getSoTienCoc() { return soTienCoc; }
    public void setSoTienCoc(Double soTienCoc) { this.soTienCoc = soTienCoc; }

    public Double getSoTienHoanTra() { return soTienHoanTra; }
    public void setSoTienHoanTra(Double soTienHoanTra) { this.soTienHoanTra = soTienHoanTra; }

    public String getLyDoKhauTru() { return lyDoKhauTru; }
    public void setLyDoKhauTru(String lyDoKhauTru) { this.lyDoKhauTru = lyDoKhauTru; }

    public LocalDate getNgayHoanTra() { return ngayHoanTra; }
    public void setNgayHoanTra(LocalDate ngayHoanTra) { this.ngayHoanTra = ngayHoanTra; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
