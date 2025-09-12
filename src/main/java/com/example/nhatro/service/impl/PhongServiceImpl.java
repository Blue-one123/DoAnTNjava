package com.example.nhatro.service.impl;

import com.example.nhatro.dto.PhongDTO;
import com.example.nhatro.entity.Phong;
import com.example.nhatro.mapper.PhongMapper;
import com.example.nhatro.repository.PhongRepository;
import com.example.nhatro.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PhongServiceImpl implements PhongService {

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public Page<PhongDTO> getAllPhong(int page, int size) {
        return phongRepository.findAll(PageRequest.of(page, size))
                .map(PhongMapper::toDTO); // ✅ chuyển entity -> dto
    }

    @Override
    public PhongDTO getPhongById(Long id) {
        Phong phong = phongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng có id = " + id));
        return PhongMapper.toDTO(phong);
    }

    @Override
    public PhongDTO createPhong(PhongDTO phongDTO) {
        Phong phong = PhongMapper.toEntity(phongDTO);
        Phong saved = phongRepository.save(phong);
        return PhongMapper.toDTO(saved);
    }

    @Override
    public PhongDTO updatePhong(Long id, PhongDTO phongDTO) {
        Phong existing = phongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng có id = " + id));

        
        existing.setLoaiPhong(phongDTO.getLoaiPhong());
        existing.setGiaPhong(phongDTO.getGiaPhong());
        existing.setTrangThai(phongDTO.getTrangThai());

        Phong updated = phongRepository.save(existing);
        return PhongMapper.toDTO(updated);
    }

    @Override
    public void deletePhong(Long id) {
        phongRepository.deleteById(id);
    }
}
