package com.example.nhatro.controller;

import com.example.nhatro.dto.HopDongDTO;
import com.example.nhatro.service.HopDongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hopdong")
public class HopDongcontroller {

    @Autowired
    private HopDongService service;

    // Lấy danh sách hợp đồng (có phân trang + tìm kiếm theo keyword)
    @GetMapping
    public Page<HopDongDTO> getAll(
            @RequestParam(required = false) String keyword,
            Pageable pageable
    ) {
        return service.getAll(keyword, pageable);
    }

    // Lấy chi tiết 1 hợp đồng
    @GetMapping("/{id}")
    public HopDongDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Tạo hợp đồng mới
    @PostMapping
    public HopDongDTO create(@Valid @RequestBody HopDongDTO dto) {
        return service.create(dto);
    }

    // Cập nhật hợp đồng
    @PutMapping("/{id}")
    public HopDongDTO update(@PathVariable Long id, @Valid @RequestBody HopDongDTO dto) {
        return service.update(id, dto);
    }

    // Xóa hợp đồng
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
