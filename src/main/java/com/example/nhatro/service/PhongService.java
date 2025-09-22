package com.example.nhatro.service;

import com.example.nhatro.dto.PhongDTO;
import java.util.List;

public interface PhongService {
    List<PhongDTO> getAllPhong();
    PhongDTO getPhongById(Long id);
    PhongDTO createPhong(PhongDTO phongDTO);
    PhongDTO updatePhong(Long id, PhongDTO phongDTO);
    void deletePhong(Long id);
}
