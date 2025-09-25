package com.example.nhatro.service;

import com.example.nhatro.dto.HoaDonDTO;
import java.util.List;

public interface HoaDonService {
    HoaDonDTO createHoaDon(HoaDonDTO hoaDonDTO);
    HoaDonDTO updateHoaDon(Long id, HoaDonDTO hoaDonDTO);
    void deleteHoaDon(Long id);
    HoaDonDTO getHoaDonById(Long id);
    List<HoaDonDTO> getAllHoaDon();
}
