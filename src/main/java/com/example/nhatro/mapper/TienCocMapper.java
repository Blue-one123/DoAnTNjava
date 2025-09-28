package com.example.nhatro.mapper;

import com.example.nhatro.dto.TienCocDTO;
import com.example.nhatro.entity.TienCoc;

public class TienCocMapper {

    public static TienCocDTO toDTO(TienCoc entity) {
        if (entity == null) return null;
        TienCocDTO dto = new TienCocDTO();
        dto.setId(entity.getId());
        dto.setHopDongId(entity.getHopDong().getId());
        dto.setMaHopDong(entity.getHopDong().getMaHopDong());
        dto.setSoTienCoc(entity.getSoTienCoc());
        dto.setSoTienHoanTra(entity.getSoTienHoanTra());
        dto.setLyDoKhauTru(entity.getLyDoKhauTru());
        dto.setNgayHoanTra(entity.getNgayHoanTra());
        return dto;
    }
}
