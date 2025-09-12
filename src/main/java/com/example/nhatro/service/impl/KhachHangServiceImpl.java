package com.example.nhatro.service.impl;

import com.example.nhatro.dto.KhachHangDTO;
import com.example.nhatro.entity.KhachHang;
import com.example.nhatro.mapper.KhachHangMapper;
import com.example.nhatro.repository.KhachHangRepository;
import com.example.nhatro.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository repository;

    @Autowired
    private KhachHangMapper mapper;

    @Override
    public Page<KhachHangDTO> getAllKhachHang(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).map(mapper::toDTO);
    }

    @Override
    public KhachHangDTO getKhachHangById(Long id) {
        KhachHang entity = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy khách hàng với id = " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public KhachHangDTO createKhachHang(KhachHangDTO dto) {
        KhachHang entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public KhachHangDTO updateKhachHang(Long id, KhachHangDTO dto) {
        KhachHang entity = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy khách hàng với id = " + id));

        entity.setTenKhachHang(dto.getTenKhachHang());
        entity.setSoDienThoai(dto.getSoDienThoai());
        entity.setDiaChi(dto.getDiaChi());
        entity.setEmail(dto.getEmail());

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void deleteKhachHang(Long id) {
        repository.deleteById(id);
    }
}
