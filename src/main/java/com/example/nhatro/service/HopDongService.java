package com.example.nhatro.service;

import com.example.nhatro.dto.HopDongDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HopDongService {
    Page<HopDongDTO> getAll(String keyword, Pageable pageable);

    HopDongDTO getById(Long id);

    HopDongDTO create(HopDongDTO dto);

    HopDongDTO update(Long id, HopDongDTO dto);

    void delete(Long id);
}
