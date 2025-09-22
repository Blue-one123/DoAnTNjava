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
        return dto;
    }

    public static Phong toEntity(PhongDTO dto) {
        if (dto == null) return null;
        
        Phong phong = new Phong();
       
        phong.setId(dto.getId());
        phong.setMaPhong(dto.getMaPhong());
        phong.setLoaiPhong(dto.getLoaiPhong());
        phong.setGiaPhong(dto.getGiaPhong());
        phong.setTrangThai(dto.getTrangThai());
        phong.setMoTa(dto.getMoTa());
        return phong;
    }
}
