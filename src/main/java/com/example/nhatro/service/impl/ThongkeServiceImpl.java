package com.example.nhatro.service.impl;

import com.example.nhatro.entity.HoaDon;
import com.example.nhatro.entity.KhachHang;
import com.example.nhatro.entity.Phong;
import com.example.nhatro.repository.HoaDonRepository;
import com.example.nhatro.repository.KhachHangRepository;
import com.example.nhatro.repository.PhongRepository;
import com.example.nhatro.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ThongkeServiceImpl implements ThongKeService {

    @Autowired
    private PhongRepository phongRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    // ✅ 1. Tổng số phòng
    @Override
    public Long tongSoPhong() {
        return phongRepository.count();
    }

    // ✅ 2. Số khách hàng đang sử dụng phòng
   
   @Override
    public Long tongKhachHang() {
        return khachHangRepository.count();
    }


    // ✅ 3. Tổng doanh thu
    @Override
    public Double tongDoanhThu() {
        return hoaDonRepository.findAll().stream()
                .mapToDouble(HoaDon::getTongTien)
                .sum();
    }

    // ✅ 4. Doanh thu theo tháng trong 1 năm
    @Override
    public Map<String, Double> doanhThuTheoThang(int year) {
        Map<String, Double> result = new LinkedHashMap<>();

        // Khởi tạo 12 tháng = 0
        for (int i = 1; i <= 12; i++) {
            result.put("Tháng " + i, 0.0);
        }

        List<HoaDon> hoaDons = hoaDonRepository.findAll();

        for (HoaDon hd : hoaDons) {
            if (hd.getNgayTao() != null && hd.getNgayTao().getYear() == year) {
                int month = hd.getNgayTao().getMonthValue();
                result.put("Tháng " + month,
                        result.get("Tháng " + month) + hd.getTongTien());
            }
        }
        return result;
    }

    // ✅ 5. Thống kê phòng theo trạng thái
    @Override
    public List<Map<String, Object>> thongKePhongTheoTrangThai(String trangThai) {
        List<Phong> dsPhong = phongRepository.findByTrangThai(trangThai);

        return dsPhong.stream()
                .map(phong -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", phong.getId());
                    map.put("tenPhong", phong.getMaPhong());
                    map.put("trangThai", phong.getTrangThai());
                    map.put("giaPhong", phong.getGiaPhong());
                    return map;
                })
                .collect(Collectors.toList());
    }
}
