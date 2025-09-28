package com.example.nhatro.controller;

import com.example.nhatro.dto.PhongDTO;
import com.example.nhatro.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/phong")
public class Phongcontroller {

    @Autowired
    private PhongService phongService;

    // ✅ Lấy toàn bộ danh sách phòng (không phân trang)
    @GetMapping("/all")
    public List<PhongDTO> getAllPhong() {
        return phongService.getAllPhong();
    }

    // ✅ Thêm phòng
    @PostMapping
    public PhongDTO createPhong(@RequestBody PhongDTO phongDTO) {
        return phongService.createPhong(phongDTO);
    }

    // ✅ Sửa phòng theo id
    @PutMapping("/{id}")
    public PhongDTO updatePhong(@PathVariable Long id, @RequestBody PhongDTO phongDTO) {
        return phongService.updatePhong(id, phongDTO);
    }

    // ✅ Xóa phòng
    @DeleteMapping("/{id}")
    public void deletePhong(@PathVariable Long id) {
        phongService.deletePhong(id);
    }

    // ✅ API cho select tất cả phòng (id + mã phòng)
    @GetMapping("/list-select")
    public List<Map<String, Object>> getPhongForSelect() {
        return phongService.getAllPhong()
                .stream()
                .map(ph -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", ph.getId());
                    map.put("ten", ph.getMaPhong()); // dùng maPhong để hiển thị
                    return map;
                })
                .collect(Collectors.toList());
    }

    // ✅ API cho select phòng còn trống (id + mã phòng + giá)
    @GetMapping("/list-available")
    public ResponseEntity<List<Map<String, Object>>> getAvailablePhongForSelect() {
        List<Map<String, Object>> result = phongService.getAvailablePhong() // ⚡ gọi qua instance
                .stream()
                .map(phong -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", phong.getId());
                    map.put("ten", phong.getMaPhong());
                    map.put("gia", phong.getGiaPhong()); // trả luôn giá phòng
                    return map;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}
