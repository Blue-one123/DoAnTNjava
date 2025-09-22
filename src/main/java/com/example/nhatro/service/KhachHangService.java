package com.example.nhatro.service;

import com.example.nhatro.dto.KhachHangDTO;
import java.util.List;
import org.springframework.data.domain.Page;

public interface KhachHangService {
    Page<KhachHangDTO> getAllKhachHang(int page, int size);
    List<KhachHangDTO> getAllKhachHangNoPaging();

    KhachHangDTO getKhachHangById(Long id);
    KhachHangDTO createKhachHang(KhachHangDTO dto);
    KhachHangDTO updateKhachHang(Long id, KhachHangDTO dto);
    void deleteKhachHang(Long id);
}
