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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HopDongServiceImpl implements HopDongService {

    private final HopDongRepository hopDongRepo;
    private final KhachHangRepository khachHangRepo;
    private final PhongRepository phongRepo;

    public HopDongServiceImpl(
            HopDongRepository hopDongRepo,
            KhachHangRepository khachHangRepo,
            PhongRepository phongRepo
    ) {
        this.hopDongRepo = hopDongRepo;
        this.khachHangRepo = khachHangRepo;
        this.phongRepo = phongRepo;
    }

    @Override
    public HopDongDTO createHopDong(HopDongDTO dto) {
    // set trạng thái mặc định
    dto.setTrangThai(HopDong.TrangThaiHopDong.ChoDuyet.name());

    // tìm khách hàng từ tên
    KhachHang khachHang = khachHangRepo.findByTenKhachHang(dto.getTenKhachHang())
            .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng: " + dto.getTenKhachHang()));

    // tìm phòng từ mã phòng
    Phong phong = phongRepo.findByMaPhong(dto.getMaPhong())
            .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng: " + dto.getMaPhong()));

    // tạo hợp đồng
    HopDong entity = HopDongMapper.toEntity(dto, khachHang, phong);

    // gắn ngược lại quan hệ
    khachHang.setPhong(phong);
    khachHang.setHopDong(entity);

    phong.setKhachHang(khachHang);
    phong.setHopDong(entity);

    // lưu
    hopDongRepo.save(entity);
    khachHangRepo.save(khachHang);
    phongRepo.save(phong);

    return HopDongMapper.toDTO(entity);
    }
    @Override
    public HopDongDTO updateHopDong(Long id, HopDongDTO dto) {
        HopDong hd = hopDongRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng"));

        // load lại khách hàng + phòng
        KhachHang khachHang = khachHangRepo.findByTenKhachHang(dto.getTenKhachHang())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng: " + dto.getTenKhachHang()));
        Phong phong = phongRepo.findByMaPhong(dto.getMaPhong())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng: " + dto.getMaPhong()));

        // cập nhật dữ liệu
        hd.setKhachHang(khachHang);
        hd.setPhong(phong);
        hd.setNgayBatDau(dto.getNgayBatDau());
        hd.setNgayKetThuc(dto.getNgayKetThuc());
        hd.setSoTienCoc(dto.getSoTienCoc());
        hd.setSoTienThue(dto.getSoTienThue());
        hd.setFileHopDong(dto.getFileHopDong());
        hd.setGhiChu(dto.getGhiChu());

        if (dto.getTrangThai() != null) {
            hd.setTrangThai(HopDong.TrangThaiHopDong.valueOf(dto.getTrangThai()));
        }

        return HopDongMapper.toDTO(hopDongRepo.save(hd));
    }

    @Override
    public void deleteHopDong(Long id) {
        hopDongRepo.deleteById(id);
    }

    @Override
    public HopDongDTO getHopDongById(Long id) {
        return hopDongRepo.findById(id)
                .map(HopDongMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng"));
    }

    @Override
    public List<HopDongDTO> getAllHopDong() {
        return hopDongRepo.findAll()
                .stream()
                .map(HopDongMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HopDongDTO duyetHopDong(Long id) {
        HopDong hd = hopDongRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng"));
        hd.setTrangThai(HopDong.TrangThaiHopDong.DangHieuLuc);

        return HopDongMapper.toDTO(hopDongRepo.save(hd));
    }

    @Override
    public HopDongDTO ketThucHopDong(Long id) {
        HopDong hd = hopDongRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng"));
        hd.setTrangThai(HopDong.TrangThaiHopDong.HetHan);

        return HopDongMapper.toDTO(hopDongRepo.save(hd));
    }

    @Override
    public HopDongDTO huyHopDong(Long id) {
        HopDong hd = hopDongRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng"));
        hd.setTrangThai(HopDong.TrangThaiHopDong.Huy);

        return HopDongMapper.toDTO(hopDongRepo.save(hd));
    }
}
