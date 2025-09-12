package com.example.nhatro.mapper;

import com.example.nhatro.dto.PhongDTO;
import com.example.nhatro.entity.Phong;


public class PhongMapper {

    public static PhongDTO toDTO(Phong phong) {
        if (phong == null) return null;

        PhongDTO dto = new PhongDTO();
        dto.setMaPhong(phong.getMaPhong());
        
        dto.setLoaiPhong(phong.getLoaiPhong());
        dto.setGiaPhong(phong.getGiaPhong());
        dto.setTrangThai(phong.getTrangThai());
        return dto;
    }

    public static Phong toEntity(PhongDTO dto) {
        if (dto == null) return null;

        Phong phong = new Phong();
        phong.setMaPhong(dto.getMaPhong());
        
        phong.setLoaiPhong(dto.getLoaiPhong());
        phong.setGiaPhong(dto.getGiaPhong());
        phong.setTrangThai(dto.getTrangThai());
        return phong;
    }
}
