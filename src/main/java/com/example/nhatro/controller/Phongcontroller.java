package com.example.nhatro.controller;

import com.example.nhatro.dto.PhongDTO;
import com.example.nhatro.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phong")
public class Phongcontroller {

    @Autowired
    private PhongService service;

    // Lấy danh sách phòng (có phân trang)
    @GetMapping
    public Page<PhongDTO> getAllPhong(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.getAllPhong(page, size); // ✅ đúng method
    }

    // Lấy 1 phòng theo ID
    @GetMapping("/{id}")
    public PhongDTO getPhongById(@PathVariable Long id) {
        return service.getPhongById(id); // ✅ đúng method
    }

    // Tạo phòng mới
    @PostMapping
    public PhongDTO createPhong(@RequestBody PhongDTO phongDTO) {
        return service.createPhong(phongDTO); // ✅ đúng method
    }

    // Cập nhật phòng
    @PutMapping("/{id}")
    public PhongDTO updatePhong(@PathVariable Long id, @RequestBody PhongDTO phongDTO) {
        return service.updatePhong(id, phongDTO); // ✅ đúng method
    }

    // Xóa phòng
    @DeleteMapping("/{id}")
    public void deletePhong(@PathVariable Long id) {
        service.deletePhong(id); // ✅ đúng method
    }
}
