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
        dto.setNgaySinh(entity.getNgaySinh());
        dto.setDiaChi(entity.getDiaChi());
        dto.setEmail(entity.getEmail());
        dto.setCccd(entity.getCccd());
        return dto;
    }

    public KhachHang toEntity(KhachHangDTO dto) {
        if (dto == null) return null;

        KhachHang entity = new KhachHang();
        entity.setId(dto.getId());
        entity.setTenKhachHang(dto.getTenKhachHang());
        entity.setSoDienThoai(dto.getSoDienThoai());
        entity.setNgaySinh(dto.getNgaySinh());
        entity.setDiaChi(dto.getDiaChi());
        entity.setEmail(dto.getEmail());
        entity.setCccd(dto.getCccd());
        return entity;
    }
}
