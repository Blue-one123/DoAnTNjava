package com.example.nhatro.service.impl;

import com.example.nhatro.dto.HoaDonDTO;
import com.example.nhatro.entity.HoaDon;
import com.example.nhatro.entity.KhachHang;
import com.example.nhatro.entity.Phong;
import com.example.nhatro.mapper.HoaDonMapper;
import com.example.nhatro.repository.HoaDonRepository;
import com.example.nhatro.repository.KhachHangRepository;
import com.example.nhatro.repository.PhongRepository;
import com.example.nhatro.service.HoaDonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private PhongRepository phongRepository;

    @Autowired
    private HoaDonMapper hoaDonMapper;

    @Override
    public HoaDonDTO createHoaDon(HoaDonDTO dto) {
        HoaDon hoaDon = hoaDonMapper.toEntity(dto);

        KhachHang khachHang = khachHangRepository.findById(dto.getKhachHangId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));
        hoaDon.setKhachHang(khachHang);

        Phong phong = phongRepository.findById(dto.getPhongId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));
        hoaDon.setPhong(phong);

        HoaDon saved = hoaDonRepository.save(hoaDon);
        return hoaDonMapper.toDTO(saved);
    }

    @Override
    public HoaDonDTO updateHoaDon(Long id, HoaDonDTO dto) {
        HoaDon existing = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn"));

        // update field từ DTO
        existing.setNgayTao(dto.getNgayTao());
        existing.setTienPhong(dto.getTienPhong());
        existing.setSoDien(dto.getSoDien());
        existing.setDonGiaDien(dto.getDonGiaDien());
        existing.setSoNuoc(dto.getSoNuoc());
        existing.setDonGiaNuoc(dto.getDonGiaNuoc());
        existing.setDichVuKhac(dto.getDichVuKhac());
        existing.setTrangThai(dto.getTrangThai());
        existing.setGhiChu(dto.getGhiChu());

        // update quan hệ
        if (dto.getKhachHangId() != null) {
            KhachHang khachHang = khachHangRepository.findById(dto.getKhachHangId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));
            existing.setKhachHang(khachHang);
        }

        if (dto.getPhongId() != null) {
            Phong phong = phongRepository.findById(dto.getPhongId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));
            existing.setPhong(phong);
        }

        HoaDon updated = hoaDonRepository.save(existing);
        return hoaDonMapper.toDTO(updated);
    }

    @Override
    public void deleteHoaDon(Long id) {
        HoaDon existing = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn"));
        hoaDonRepository.delete(existing);
    }

    @Override
    public List<HoaDonDTO> getAllHoaDon() {
        return hoaDonRepository.findAll()
                .stream()
                .map(hoaDonMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HoaDonDTO getHoaDonById(Long id) {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn"));
        return hoaDonMapper.toDTO(hoaDon);
    }
}
