
package com.example.nhatro.service.impl;


import com.example.nhatro.entity.HoaDon;
import com.example.nhatro.entity.Phong;
import com.example.nhatro.repository.HoaDonRepository;
import com.example.nhatro.repository.PhongRepository;
import com.example.nhatro.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ThongkeServiceImpl implements ThongKeService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public Map<String, Double> doanhThuTheoThang(int year) {
        List<HoaDon> hoaDons = hoaDonRepository.findAll();

        return hoaDons.stream()
                .filter(hd -> hd.getNgayTao().getYear() == year && "Đã thanh toán".equals(hd.getTrangThai()))
                .collect(Collectors.groupingBy(
                        hd -> hd.getNgayTao().getMonth().toString(),
                        Collectors.summingDouble(HoaDon::getTongTien)
                ));
    }

    @Override
    public List<String> danhSachPhongTheoTrangThai(String trangThai) {
        List<Phong> phongs = phongRepository.findByTrangThai(trangThai);
        return phongs.stream()
                .map(p -> "Phòng: " + p.getMaPhong() + " - Loại: " + p.getLoaiPhong() + " - Giá: " + p.getGiaPhong())
                .collect(Collectors.toList());
    }

    @Override
    public Double chiPhiTrungBinhTheoThang(int month, int year) {
        List<HoaDon> hoaDons = hoaDonRepository.findAll();

        List<HoaDon> filtered = hoaDons.stream()
                .filter(hd -> hd.getNgayTao().getYear() == year && hd.getNgayTao().getMonthValue() == month)
                .toList();

        if (filtered.isEmpty()) return 0.0;

        double tongChiPhi = filtered.stream().mapToDouble(HoaDon::getTongTien).sum();
        return tongChiPhi / filtered.size();
    }

    @Override
    public List<String> topKhachHangThueLau() {
        // Giả sử sẽ bổ sung sau từ bảng HopDong
        return List.of("Khách hàng A - 24 tháng", "Khách hàng B - 18 tháng");
    }

    @Override
    public List<String> danhSachNoTien() {
        List<HoaDon> hoaDons = hoaDonRepository.findByTrangThai("Chưa thanh toán");
        return hoaDons.stream()
                .map(hd -> "Hóa đơn ID: " + hd.getId() + " - KH: " + hd.getKhachHang().getTenKhachHang() +
                        " - Phòng: " + hd.getPhong().getMaPhong() + " - Số tiền: " + hd.getTongTien())
                .collect(Collectors.toList());
    }
}
