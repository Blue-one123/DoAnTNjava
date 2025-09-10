package com.example.nhatro.service.impl;

import com.example.nhatro.entity.KhachHang;
import com.example.nhatro.repository.KhachHangRepository;
import com.example.nhatro.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang getKhachHangById(Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public KhachHang saveKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang updateKhachHang(Long id, KhachHang khachHang) {
        Optional<KhachHang> existing = khachHangRepository.findById(id);
        if (existing.isPresent()) {
            KhachHang k = existing.get();
            k.setHoTen(khachHang.getHoTen());
            k.setSoDienThoai(khachHang.getSoDienThoai());
            k.setDiaChi(khachHang.getDiaChi());
            k.setCccd(khachHang.getCccd());
            return khachHangRepository.save(k);
        }
        return null;
    }

    @Override
    public void deleteKhachHang(Long id) {
        khachHangRepository.deleteById(id);
    }
}
