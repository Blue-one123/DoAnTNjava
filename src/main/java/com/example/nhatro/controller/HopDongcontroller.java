package com.example.nhatro.controller;

import com.example.nhatro.dto.HopDongDTO;
import com.example.nhatro.entity.KhachHang;
import com.example.nhatro.repository.KhachHangRepository;
import com.example.nhatro.service.HopDongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hopdong")
public class HopDongcontroller {

    private final HopDongService hopDongService;

    public HopDongcontroller(HopDongService hopDongService) {
        this.hopDongService = hopDongService;
    }

    @PostMapping
    public HopDongDTO create(@RequestBody HopDongDTO dto) {
        return hopDongService.createHopDong(dto);
    }
   

    @PutMapping("/{id}")
    public HopDongDTO update(@PathVariable Long id, @RequestBody HopDongDTO dto) {
        return hopDongService.updateHopDong(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hopDongService.deleteHopDong(id);
    }

    @GetMapping("/{id}")
    public HopDongDTO getById(@PathVariable Long id) {
        return hopDongService.getHopDongById(id);
    }

    @GetMapping
    public List<HopDongDTO> getAll() {
        return hopDongService.getAllHopDong();
    }

    // Các API nghiệp vụ
    @PostMapping("/{id}/duyet")
    public HopDongDTO duyet(@PathVariable Long id) {
        return hopDongService.duyetHopDong(id);
    }

    @PostMapping("/{id}/ketthuc")
    public HopDongDTO ketThuc(@PathVariable Long id) {
        return hopDongService.ketThucHopDong(id);
    }

    @PostMapping("/{id}/huy")
    public HopDongDTO huy(@PathVariable Long id) {
        return hopDongService.huyHopDong(id);
    }
}
