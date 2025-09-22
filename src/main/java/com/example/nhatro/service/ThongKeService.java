package com.example.nhatro.service;

import java.util.List;
import java.util.Map;

public interface ThongKeService {

    // ✅ Tổng số phòng
    Long tongSoPhong();

    // ✅ Số khách hàng đang sử dụng phòng
    Long tongKhachHang();


    // ✅ Tổng doanh thu
    Double tongDoanhThu();

    // ✅ Doanh thu theo tháng trong 1 năm
    Map<String, Double> doanhThuTheoThang(int year);

    // ✅ Thống kê phòng theo trạng thái (Trống, Đang thuê, Bảo trì...)
    List<Map<String, Object>> thongKePhongTheoTrangThai(String trangThai);
}
