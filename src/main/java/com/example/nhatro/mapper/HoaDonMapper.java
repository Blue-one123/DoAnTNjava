package com.example.nhatro.mapper;

import com.example.nhatro.dto.HoaDonDTO;
import com.example.nhatro.entity.HoaDon;

public class HoaDonMapper {

    public static HoaDonDTO toDTO(HoaDon hoaDon) {
        HoaDonDTO dto = new HoaDonDTO();
        dto.setId(hoaDon.getId());
        dto.setMaHoaDon(hoaDon.getMaHoaDon());

        if (hoaDon.getKhachHang() != null) {
            dto.setKhachHangId(hoaDon.getKhachHang().getId());
            dto.setTenKhachHang(hoaDon.getKhachHang().getTenKhachHang());
        }

        if (hoaDon.getPhong() != null) {
            dto.setPhongId(hoaDon.getPhong().getId());
            dto.setMaPhong(hoaDon.getPhong().getMaPhong());
        }

        dto.setTongTien(hoaDon.getTongTien());
        dto.setNgayTao(hoaDon.getNgayTao());
        dto.setGhiChu(hoaDon.getGhiChu());
        dto.setTrangThai(hoaDon.getTrangThai());

        return dto;
    }
}
