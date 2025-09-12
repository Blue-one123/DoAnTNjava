package com.example.nhatro.mapper;

import com.example.nhatro.dto.HopDongDTO;
import com.example.nhatro.entity.HopDong;

public class HopDongMapper {

    public static HopDongDTO toDTO(HopDong hopDong) {
        if (hopDong == null) return null;

        HopDongDTO dto = new HopDongDTO();
        dto.setId(hopDong.getId());

        if (hopDong.getKhachHang() != null) {
            dto.setKhachHangId(hopDong.getKhachHang().getId());
            dto.setTenKhachHang(hopDong.getKhachHang().getTenKhachHang());
        }

        if (hopDong.getPhong() != null) {
            dto.setPhongId(hopDong.getPhong().getId());
            dto.setMaPhong(hopDong.getPhong().getMaPhong());
        }

        dto.setNgayBatDau(hopDong.getNgayBatDau());
        dto.setNgayKetThuc(hopDong.getNgayKetThuc());
        dto.setTienDatCoc(hopDong.getTienDatCoc());
        dto.setGiaThue(hopDong.getGiaThue());
        dto.setTrangThai(hopDong.getTrangThai());
        dto.setPhuongThucThanhToan(hopDong.getPhuongThucThanhToan());
        dto.setGhiChu(hopDong.getGhiChu());

        return dto;
    }

    public static HopDong toEntity(HopDongDTO dto) {
        if (dto == null) return null;

        HopDong hopDong = new HopDong();
        hopDong.setId(dto.getId());
        hopDong.setNgayBatDau(dto.getNgayBatDau());
        hopDong.setNgayKetThuc(dto.getNgayKetThuc());
        hopDong.setTienDatCoc(dto.getTienDatCoc());
        hopDong.setGiaThue(dto.getGiaThue());
        hopDong.setTrangThai(dto.getTrangThai());
        hopDong.setPhuongThucThanhToan(dto.getPhuongThucThanhToan());
        hopDong.setGhiChu(dto.getGhiChu());

        // ⚠️ KhachHang và Phong sẽ được set trong Service khi lấy từ repository
        return hopDong;
    }
}
