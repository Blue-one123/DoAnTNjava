package com.example.nhatro.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class HoaDonDTO {
    private Long id;

    @NotNull
    private Long phongId;

    @NotNull
    private Long khachHangId;

    @NotNull
    private LocalDate ngayTao;

    @Min(0)
    private Double tienPhong;

    @Min(0)
    private Integer soDien;

    @Min(0)
    private Double donGiaDien;

    @Min(0)
    private Integer soNuoc;

    @Min(0)
    private Double donGiaNuoc;

    @Min(0)
    private Double dichVuKhac;
    private String maHoaDon;   
    private Double tongTien;
    private String trangThai;
    private String ghiChu;
    private String tenKhachHang; 
    private String maPhong;
}
