package com.example.nhatro.service.impl;

import com.example.nhatro.dto.TienCocDTO;
import com.example.nhatro.entity.HopDong;
import com.example.nhatro.entity.TienCoc;
import com.example.nhatro.mapper.TienCocMapper;
import com.example.nhatro.repository.HopDongRepository;
import com.example.nhatro.repository.TienCocRepository;
import com.example.nhatro.service.TienCocService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TienCocServiceImpl implements TienCocService {

    private final TienCocRepository tienCocRepository;
    private final HopDongRepository hopDongRepository;

    public TienCocServiceImpl(TienCocRepository tienCocRepository, HopDongRepository hopDongRepository) {
        this.tienCocRepository = tienCocRepository;
        this.hopDongRepository = hopDongRepository;
    }

    @Override
    @Transactional
    public TienCocDTO hoanTraTienCoc(Long hopDongId, Double soTienHoanTra, String lyDoKhauTru, String ngayHoanTra) {
        HopDong hopDong = hopDongRepository.findById(hopDongId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng"));

        TienCoc tienCoc = new TienCoc();
        tienCoc.setHopDong(hopDong);
        tienCoc.setSoTienCoc(hopDong.getSoTienCoc());
        tienCoc.setSoTienHoanTra(soTienHoanTra);
        tienCoc.setLyDoKhauTru(lyDoKhauTru);
        tienCoc.setNgayHoanTra(LocalDate.parse(ngayHoanTra));

        return TienCocMapper.toDTO(tienCocRepository.save(tienCoc));
    }

    @Override
    public List<TienCocDTO> getAll() {
        return tienCocRepository.findAll()
                .stream().map(TienCocMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TienCocDTO getById(Long id) {
        return tienCocRepository.findById(id)
                .map(TienCocMapper::toDTO)
                .orElse(null);
    }
}
