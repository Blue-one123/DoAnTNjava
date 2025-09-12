
package com.example.nhatro.controller;


import com.example.nhatro.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/thongke")
public class ThongKecontroller {

    @Autowired
    private ThongKeService thongKeService;

    @GetMapping("/doanhthu/{year}")
    public Map<String, Double> getDoanhThuTheoThang(@PathVariable int year) {
        return thongKeService.doanhThuTheoThang(year);
    }

    @GetMapping("/phong")
    public List<String> getPhongTheoTrangThai(@RequestParam String trangThai) {
        return thongKeService.danhSachPhongTheoTrangThai(trangThai);
    }

    @GetMapping("/chiphi/{month}/{year}")
    public Double getChiPhiTrungBinh(@PathVariable int month, @PathVariable int year) {
        return thongKeService.chiPhiTrungBinhTheoThang(month, year);
    }

    @GetMapping("/topkhachhang")
    public List<String> getTopKhachHang() {
        return thongKeService.topKhachHangThueLau();
    }

    @GetMapping("/notien")
    public List<String> getDanhSachNoTien() {
        return thongKeService.danhSachNoTien();
    }
}
