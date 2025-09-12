package com.example.nhatro.service;

import com.example.nhatro.dto.PhongDTO;
import org.springframework.data.domain.Page;

public interface PhongService {
    Page<PhongDTO> getAllPhong(int page, int size);
    PhongDTO getPhongById(Long id);
    PhongDTO createPhong(PhongDTO phongDTO);
    PhongDTO updatePhong(Long id, PhongDTO phongDTO);
    void deletePhong(Long id);
}
