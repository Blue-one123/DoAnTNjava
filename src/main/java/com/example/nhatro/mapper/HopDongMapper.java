package com.example.nhatro.mapper;

import com.example.nhatro.dto.HopDongDTO;
import com.example.nhatro.entity.HopDong;
import com.example.nhatro.entity.KhachHang;
import com.example.nhatro.entity.Phong;

public class HopDongMapper {

    // Entity -> DTO
    public static HopDongDTO toDTO(HopDong hopDong) {
        if (hopDong == null) return null;

        HopDongDTO dto = new HopDongDTO();
        dto.setId(hopDong.getId());
        dto.setMaHopDong(hopDong.getMaHopDong());

        // Lấy tên khách hàng từ entity KhachHang hoặc cột tenKhachHang
        if (hopDong.getKhachHang() != null) {
            dto.setTenKhachHang(hopDong.getKhachHang().getTenKhachHang());
        } else {
            dto.setTenKhachHang(hopDong.getTenKhachHang());
        }

        // Lấy mã phòng từ entity Phong hoặc cột maPhong
        if (hopDong.getPhong() != null) {
            dto.setMaPhong(hopDong.getPhong().getMaPhong());
        } else {
            dto.setMaPhong(hopDong.getMaPhong());
        }

        dto.setNgayBatDau(hopDong.getNgayBatDau());
        dto.setNgayKetThuc(hopDong.getNgayKetThuc());
        dto.setSoTienCoc(hopDong.getSoTienCoc());
        dto.setSoTienThue(hopDong.getSoTienThue());
        dto.setFileHopDong(hopDong.getFileHopDong());
        dto.setTrangThai(hopDong.getTrangThai() != null ? hopDong.getTrangThai().name() : null);
        dto.setGhiChu(hopDong.getGhiChu());
        dto.setCreatedAt(hopDong.getCreatedAt());
        dto.setUpdatedAt(hopDong.getUpdatedAt());

        return dto;
    }

    // DTO -> Entity
    public static HopDong toEntity(HopDongDTO dto, KhachHang khachHang, Phong phong) {
        if (dto == null) return null;

        HopDong hopDong = new HopDong();
        hopDong.setId(dto.getId());
        hopDong.setMaHopDong(dto.getMaHopDong());

        // set cả string và entity để tránh null
        hopDong.setTenKhachHang(dto.getTenKhachHang());
        hopDong.setKhachHang(khachHang);

        hopDong.setMaPhong(dto.getMaPhong());
        hopDong.setPhong(phong);

        hopDong.setNgayBatDau(dto.getNgayBatDau());
        hopDong.setNgayKetThuc(dto.getNgayKetThuc());
        hopDong.setSoTienCoc(dto.getSoTienCoc());
        hopDong.setSoTienThue(dto.getSoTienThue());
        hopDong.setFileHopDong(dto.getFileHopDong());

        if (dto.getTrangThai() != null) {
            hopDong.setTrangThai(HopDong.TrangThaiHopDong.valueOf(dto.getTrangThai()));
        }

        hopDong.setGhiChu(dto.getGhiChu());
        return hopDong;
    }
}
