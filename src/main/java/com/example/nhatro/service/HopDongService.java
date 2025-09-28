package com.example.nhatro.service;

import com.example.nhatro.dto.HopDongDTO;
import java.util.List;

public interface HopDongService {
    HopDongDTO createHopDong(HopDongDTO dto);
    HopDongDTO updateHopDong(Long id, HopDongDTO dto);
    void deleteHopDong(Long id);
    HopDongDTO getHopDongById(Long id);
    List<HopDongDTO> getAllHopDong();

    // Nghiệp vụ
    HopDongDTO duyetHopDong(Long id);       // admin duyệt
    HopDongDTO ketThucHopDong(Long id);     // kết thúc
    HopDongDTO huyHopDong(Long id);         // hủy
}
