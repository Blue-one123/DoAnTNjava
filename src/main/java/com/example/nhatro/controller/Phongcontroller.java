package com.example.nhatro.controller;

import com.example.nhatro.dto.PhongDTO;
import com.example.nhatro.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phong")
public class Phongcontroller {

    @Autowired
    private PhongService service;

    // ✅ Lấy toàn bộ danh sách phòng (không phân trang)
    @GetMapping("/all")
    public List<PhongDTO> getAllPhong() {
        return service.getAllPhong();
    }

    // ✅ Thêm phòng
    @PostMapping
    public PhongDTO createPhong(@RequestBody PhongDTO phongDTO) {
        return service.createPhong(phongDTO);
    }

    // ✅ Sửa phòng theo id
    @PutMapping("/{id}")
    public PhongDTO updatePhong(@PathVariable Long id, @RequestBody PhongDTO phongDTO) {
        return service.updatePhong(id, phongDTO);
    }

    // ✅ Xóa phòng
    @DeleteMapping("/{id}")
    public void deletePhong(@PathVariable Long id) {
        service.deletePhong(id);
    }
}
