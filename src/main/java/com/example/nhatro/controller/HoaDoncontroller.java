package com.example.nhatro.controller;

import com.example.nhatro.dto.HoaDonDTO;
import com.example.nhatro.service.HoaDonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoadon")
public class HoaDoncontroller {

    private final HoaDonService hoaDonService;

    public HoaDoncontroller(HoaDonService hoaDonService) {
        this.hoaDonService = hoaDonService;
    }

    @GetMapping
    public List<HoaDonDTO> getAll() {
        return hoaDonService.getAll();
    }

    @GetMapping("/{id}")
    public HoaDonDTO getById(@PathVariable Long id) {
        return hoaDonService.getById(id);
    }

    @PostMapping
    public HoaDonDTO create(@RequestBody HoaDonDTO dto) {
        return hoaDonService.create(dto);
    }

    @PutMapping("/{id}")
    public HoaDonDTO update(@PathVariable Long id, @RequestBody HoaDonDTO dto) {
        return hoaDonService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hoaDonService.delete(id);
    }
}
