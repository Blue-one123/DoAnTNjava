package com.example.nhatro.mapper;

import com.example.nhatro.dto.PhongDTO;
import com.example.nhatro.entity.Phong;

public class PhongMapper {

    public static PhongDTO toDTO(Phong phong) {
        if (phong == null) return null;

        PhongDTO dto = new PhongDTO();
        dto.setId(phong.getId());
        dto.setMaPhong(phong.getMaPhong()); 
        dto.setLoaiPhong(phong.getLoaiPhong());
        dto.setGiaPhong(phong.getGiaPhong());
        dto.setTrangThai(phong.getTrangThai());
        dto.setMoTa(phong.getMoTa());
        dto.setAnhPhong(phong.getAnhPhong());

        // ⚡ Nếu cần hiển thị id khách hàng
        if (phong.getKhachHang() != null) {
            dto.setKhachHangId(phong.getKhachHang().getId());
        }

        return dto;
    }

    // ⚡ Update entity từ DTO nhưng giữ lại khachHang cũ
    public static Phong toEntity(PhongDTO dto, Phong existing) {
        if (dto == null) return null;
        if (existing == null) existing = new Phong();

        existing.setId(dto.getId());
        existing.setMaPhong(dto.getMaPhong());
        existing.setLoaiPhong(dto.getLoaiPhong());
        existing.setGiaPhong(dto.getGiaPhong());
        existing.setTrangThai(dto.getTrangThai());
        existing.setMoTa(dto.getMoTa());
        existing.setAnhPhong(dto.getAnhPhong());

        // ⚡ giữ nguyên khachHang (không set null)
        return existing;
    }

    // ⚡ Nếu muốn tạo entity mới hoàn toàn (chỉ khi thêm mới phòng)
    public static Phong toEntityNew(PhongDTO dto) {
        if (dto == null) return null;

        Phong phong = new Phong();
        phong.setId(dto.getId());
        phong.setMaPhong(dto.getMaPhong());
        phong.setLoaiPhong(dto.getLoaiPhong());
        phong.setGiaPhong(dto.getGiaPhong());
        phong.setTrangThai(dto.getTrangThai());
        phong.setMoTa(dto.getMoTa());
        phong.setAnhPhong(dto.getAnhPhong());

        // ⚡ Nếu DTO có khachHangId, bạn có thể set ở Service thay vì ở đây
        return phong;
    }
}
