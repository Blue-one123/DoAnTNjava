package com.example.nhatro.controller;

import com.example.nhatro.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/thongke")
@CrossOrigin(origins = "http://localhost:5173") // cho phép React truy cập
public class ThongKecontroller {

    @Autowired
    private ThongKeService thongKeService;

    // ✅ 1. Tổng số phòng
    @GetMapping("/tongphong")
    public Long tongSoPhong() {
        return thongKeService.tongSoPhong();
    }

    // ✅ 2. Số khách hàng đang sử dụng phòng
    @GetMapping("/tongkhachhang")
    public Long tongKhachHang() {
        return thongKeService.tongKhachHang();
}

    // ✅ 3. Tổng doanh thu
    @GetMapping("/tongdoanhthu")
    public Double tongDoanhThu() {
        return thongKeService.tongDoanhThu();
    }

    // ✅ 4. Doanh thu theo tháng trong năm
    @GetMapping("/doanhthu/{year}")
    public Map<String, Double> doanhThuTheoThang(@PathVariable int year) {
        return thongKeService.doanhThuTheoThang(year);
    }

    // ✅ 5. Thống kê phòng theo trạng thái (Trống, Đang thuê, Bảo trì...)
    @GetMapping("/phong")
    public List<Map<String, Object>> thongKePhongTheoTrangThai(@RequestParam String trangThai) {
        return thongKeService.thongKePhongTheoTrangThai(trangThai);
    }
}
