package com.example.nhatro.service;

import com.example.nhatro.dto.TienCocDTO;

import java.util.List;

public interface TienCocService {
    TienCocDTO hoanTraTienCoc(Long hopDongId, Double soTienHoanTra, String lyDoKhauTru, String ngayHoanTra);
    List<TienCocDTO> getAll();
    TienCocDTO getById(Long id);
}
