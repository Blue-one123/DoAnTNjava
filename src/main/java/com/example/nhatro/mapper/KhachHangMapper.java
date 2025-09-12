package com.example.nhatro.mapper;

import com.example.nhatro.dto.KhachHangDTO;
import com.example.nhatro.entity.KhachHang;
import org.springframework.stereotype.Component;

@Component
public class KhachHangMapper {

    public KhachHangDTO toDTO(KhachHang entity) {
        if (entity == null) return null;

        KhachHangDTO dto = new KhachHangDTO();
        dto.setId(entity.getId());
        dto.setTenKhachHang(entity.getTenKhachHang());
        dto.setSoDienThoai(entity.getSoDienThoai());
        dto.setDiaChi(entity.getDiaChi());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public KhachHang toEntity(KhachHangDTO dto) {
        if (dto == null) return null;

        KhachHang entity = new KhachHang();
        entity.setId(dto.getId());
        entity.setTenKhachHang(dto.getTenKhachHang());
        entity.setSoDienThoai(dto.getSoDienThoai());
        entity.setDiaChi(dto.getDiaChi());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
