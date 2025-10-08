package com.example.nhatro.service.impl;


import com.example.nhatro.dto.PhongDTO;
import com.example.nhatro.entity.Phong;
import com.example.nhatro.mapper.PhongMapper;
import com.example.nhatro.repository.PhongRepository;
import com.example.nhatro.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhongServiceImpl implements PhongService {

    @Autowired
    private PhongRepository phongRepository;
    

    private PhongMapper phongMapper;


    @Override
    public List<PhongDTO> getAllPhong() {
        return phongRepository.findAll()
                .stream()
                .map(PhongMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PhongDTO getPhongById(Long id) {
        Phong phong = phongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng có id = " + id));
        return PhongMapper.toDTO(phong);
    }

    @Override
    public PhongDTO createPhong(PhongDTO phongDTO) {
        Phong phong = PhongMapper.toEntityNew(phongDTO);
        Phong saved = phongRepository.save(phong);
        return PhongMapper.toDTO(saved);
    }

    @Override
    public PhongDTO updatePhong(Long id, PhongDTO phongDTO) {
        Phong existing = phongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng có id = " + id));
        Phong updatedEntity = PhongMapper.toEntity(phongDTO, existing);
        // ⚡ Lưu lại
        Phong updated = phongRepository.save(updatedEntity);
        return PhongMapper.toDTO(updated);
    }

    @Override
    public void deletePhong(Long id) {
        phongRepository.deleteById(id);
    }
    @Override
    public List<PhongDTO> getAvailablePhong() {
    return phongRepository.findByTrangThai("Trống")
            .stream()
            .map(PhongMapper::toDTO)
            .collect(Collectors.toList());
        }
    @Override
    public PhongDTO updateAnhPhong(Long id, String anhPhong) {
    Phong phong = phongRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));
    phong.setAnhPhong(anhPhong); // cập nhật đường dẫn ảnh
    phongRepository.save(phong);
    return phongMapper.toDTO(phong);
}

    

}
