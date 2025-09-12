package com.example.nhatro.service;

import com.example.nhatro.dto.HoaDonDTO;

import java.util.List;

public interface HoaDonService {
    List<HoaDonDTO> getAll();
    HoaDonDTO getById(Long id);
    HoaDonDTO create(HoaDonDTO dto);
    HoaDonDTO update(Long id, HoaDonDTO dto);
    void delete(Long id);
}
