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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonRepository hoaDonRepository;
    private final KhachHangRepository khachHangRepository;
    private final PhongRepository phongRepository;

    public HoaDonServiceImpl(HoaDonRepository hoaDonRepository,
                             KhachHangRepository khachHangRepository,
                             PhongRepository phongRepository) {
        this.hoaDonRepository = hoaDonRepository;
        this.khachHangRepository = khachHangRepository;
        this.phongRepository = phongRepository;
    }

    @Override
    public List<HoaDonDTO> getAll() {
        return hoaDonRepository.findAll()
                .stream()
                .map(HoaDonMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HoaDonDTO getById(Long id) {
        return hoaDonRepository.findById(id)
                .map(HoaDonMapper::toDTO)
                .orElse(null);
    }

    @Override
    public HoaDonDTO create(HoaDonDTO dto) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMaHoaDon(dto.getMaHoaDon());
        hoaDon.setTongTien(dto.getTongTien());
        hoaDon.setNgayTao(dto.getNgayTao());
        hoaDon.setGhiChu(dto.getGhiChu());
        hoaDon.setTrangThai(dto.getTrangThai());

        if (dto.getKhachHangId() != null) {
            KhachHang kh = khachHangRepository.findById(dto.getKhachHangId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));
            hoaDon.setKhachHang(kh);
        }

        if (dto.getPhongId() != null) {
            Phong phong = phongRepository.findById(dto.getPhongId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));
            hoaDon.setPhong(phong);
        }

        HoaDon saved = hoaDonRepository.save(hoaDon);
        return HoaDonMapper.toDTO(saved);
    }

    @Override
    public HoaDonDTO update(Long id, HoaDonDTO dto) {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn"));

        hoaDon.setMaHoaDon(dto.getMaHoaDon());
        hoaDon.setTongTien(dto.getTongTien());
        hoaDon.setNgayTao(dto.getNgayTao());
        hoaDon.setGhiChu(dto.getGhiChu());
        hoaDon.setTrangThai(dto.getTrangThai());

        if (dto.getKhachHangId() != null) {
            KhachHang kh = khachHangRepository.findById(dto.getKhachHangId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));
            hoaDon.setKhachHang(kh);
        }

        if (dto.getPhongId() != null) {
            Phong phong = phongRepository.findById(dto.getPhongId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));
            hoaDon.setPhong(phong);
        }

        HoaDon saved = hoaDonRepository.save(hoaDon);
        return HoaDonMapper.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        hoaDonRepository.deleteById(id);
    }
}
