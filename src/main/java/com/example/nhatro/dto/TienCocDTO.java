package com.example.nhatro.dto;

import java.time.LocalDate;

public class TienCocDTO {
    private Long id;
    private Long hopDongId;
    private String maHopDong;   // hiển thị
    private Double soTienCoc;
    private Double soTienHoanTra;
    private String lyDoKhauTru;
    private LocalDate ngayHoanTra;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getHopDongId() { return hopDongId; }
    public void setHopDongId(Long hopDongId) { this.hopDongId = hopDongId; }

    public String getMaHopDong() { return maHopDong; }
    public void setMaHopDong(String maHopDong) { this.maHopDong = maHopDong; }

    public Double getSoTienCoc() { return soTienCoc; }
    public void setSoTienCoc(Double soTienCoc) { this.soTienCoc = soTienCoc; }

    public Double getSoTienHoanTra() { return soTienHoanTra; }
    public void setSoTienHoanTra(Double soTienHoanTra) { this.soTienHoanTra = soTienHoanTra; }

    public String getLyDoKhauTru() { return lyDoKhauTru; }
    public void setLyDoKhauTru(String lyDoKhauTru) { this.lyDoKhauTru = lyDoKhauTru; }

    public LocalDate getNgayHoanTra() { return ngayHoanTra; }
    public void setNgayHoanTra(LocalDate ngayHoanTra) { this.ngayHoanTra = ngayHoanTra; }
}

