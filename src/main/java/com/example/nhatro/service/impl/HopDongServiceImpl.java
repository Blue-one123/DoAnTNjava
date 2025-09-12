package com.example.nhatro.service.impl;

import com.example.nhatro.dto.HopDongDTO;
import com.example.nhatro.entity.HopDong;
import com.example.nhatro.entity.KhachHang;
import com.example.nhatro.entity.Phong;
import com.example.nhatro.mapper.HopDongMapper;
import com.example.nhatro.repository.HopDongRepository;
import com.example.nhatro.repository.KhachHangRepository;
import com.example.nhatro.repository.PhongRepository;
import com.example.nhatro.service.HopDongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HopDongServiceImpl implements HopDongService {

    @Autowired
    private HopDongRepository hopDongRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public Page<HopDongDTO> getAll(String keyword, Pageable pageable) {
        Page<HopDong> page;
        if (keyword != null && !keyword.isEmpty()) {
            // Ví dụ: tìm theo tên khách hàng
            page = hopDongRepository.findByKhachHang_TenContainingIgnoreCase(keyword, pageable);
        } else {
            page = hopDongRepository.findAll(pageable);
        }
        return page.map(HopDongMapper::toDTO);
    }

    @Override
    public HopDongDTO getById(Long id) {
        HopDong hopDong = hopDongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng"));
        return HopDongMapper.toDTO(hopDong);
    }

    @Override
    public HopDongDTO create(HopDongDTO dto) {
        HopDong hopDong = HopDongMapper.toEntity(dto);

        // Gắn khách hàng
        KhachHang kh = khachHangRepository.findById(dto.getKhachHangId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));
        hopDong.setKhachHang(kh);

        // Gắn phòng
        Phong p = phongRepository.findById(dto.getPhongId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));
        hopDong.setPhong(p);

        HopDong saved = hopDongRepository.save(hopDong);
        return HopDongMapper.toDTO(saved);
    }

    @Override
    public HopDongDTO update(Long id, HopDongDTO dto) {
        HopDong hopDong = hopDongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng"));

        hopDong.setNgayBatDau(dto.getNgayBatDau());
        hopDong.setNgayKetThuc(dto.getNgayKetThuc());
        hopDong.setTienDatCoc(dto.getTienDatCoc());
        hopDong.setGiaThue(dto.getGiaThue());
        hopDong.setTrangThai(dto.getTrangThai());
        hopDong.setPhuongThucThanhToan(dto.getPhuongThucThanhToan());
        hopDong.setGhiChu(dto.getGhiChu());

        // Nếu có thay đổi khách hàng
        if (dto.getKhachHangId() != null) {
            KhachHang kh = khachHangRepository.findById(dto.getKhachHangId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));
            hopDong.setKhachHang(kh);
        }

        // Nếu có thay đổi phòng
        if (dto.getPhongId() != null) {
            Phong p = phongRepository.findById(dto.getPhongId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));
            hopDong.setPhong(p);
        }

        HopDong updated = hopDongRepository.save(hopDong);
        return HopDongMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!hopDongRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy hợp đồng để xóa");
        }
        hopDongRepository.deleteById(id);
    }
}
