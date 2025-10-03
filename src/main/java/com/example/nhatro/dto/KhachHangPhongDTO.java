package com.example.nhatro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangPhongDTO {
    private Long khachHangId;
    private String tenKhachHang;
    private Long phongId;
    private String maPhong;
    private Double giaPhong;
}
