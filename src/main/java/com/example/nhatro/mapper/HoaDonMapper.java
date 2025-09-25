package com.example.nhatro.mapper;

import com.example.nhatro.dto.HoaDonDTO;
import com.example.nhatro.entity.HoaDon;
import org.springframework.stereotype.Component;

@Component
public class HoaDonMapper {

    // Entity -> DTO
    public HoaDonDTO toDTO(HoaDon hoaDon) {
        HoaDonDTO dto = new HoaDonDTO();
        dto.setId(hoaDon.getId());
        dto.setMaHoaDon(hoaDon.getMaHoaDon());

        if (hoaDon.getKhachHang() != null) {
            dto.setKhachHangId(hoaDon.getKhachHang().getId());
            dto.setTenKhachHang(hoaDon.getKhachHang().getTenKhachHang());
            dto.setSoDienThoai(hoaDon.getKhachHang().getSoDienThoai());
        }

        if (hoaDon.getPhong() != null) {
            dto.setPhongId(hoaDon.getPhong().getId());
            dto.setMaPhong(hoaDon.getPhong().getMaPhong());
            dto.setGiaPhong(hoaDon.getPhong().getGiaPhong());
        }

        dto.setNgayTao(hoaDon.getNgayTao());
        dto.setTienPhong(hoaDon.getTienPhong());
        dto.setSoDien(hoaDon.getSoDien());
        dto.setDonGiaDien(hoaDon.getDonGiaDien());
        dto.setSoNuoc(hoaDon.getSoNuoc());
        dto.setDonGiaNuoc(hoaDon.getDonGiaNuoc());
        dto.setDichVuKhac(hoaDon.getDichVuKhac());
        dto.setTongTien(hoaDon.getTongTien());
        dto.setTrangThai(hoaDon.getTrangThai());
        dto.setGhiChu(hoaDon.getGhiChu());

        return dto;
    }

    // DTO -> Entity (chỉ map các field cơ bản, KH + Phòng sẽ set ở Service)
    public HoaDon toEntity(HoaDonDTO dto) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(dto.getId());
        hoaDon.setMaHoaDon(dto.getMaHoaDon());
        hoaDon.setNgayTao(dto.getNgayTao());
        hoaDon.setTienPhong(dto.getTienPhong());
        hoaDon.setSoDien(dto.getSoDien());
        hoaDon.setDonGiaDien(dto.getDonGiaDien());
        hoaDon.setSoNuoc(dto.getSoNuoc());
        hoaDon.setDonGiaNuoc(dto.getDonGiaNuoc());
        hoaDon.setDichVuKhac(dto.getDichVuKhac());
        hoaDon.setTongTien(dto.getTongTien());
        hoaDon.setTrangThai(dto.getTrangThai());
        hoaDon.setGhiChu(dto.getGhiChu());
        return hoaDon;
    }
}
