package com.example.nhatro.controller;

import com.example.nhatro.dto.TienCocDTO;
import com.example.nhatro.service.TienCocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiencoc")
public class TienCoccontroller {

    private final TienCocService tienCocService;

    public TienCoccontroller(TienCocService tienCocService) {
        this.tienCocService = tienCocService;
    }

    @PostMapping("/hoantra")
    public TienCocDTO hoanTra(@RequestParam Long hopDongId,
                              @RequestParam Double soTienHoanTra,
                              @RequestParam(required = false) String lyDoKhauTru,
                              @RequestParam String ngayHoanTra) {
        return tienCocService.hoanTraTienCoc(hopDongId, soTienHoanTra, lyDoKhauTru, ngayHoanTra);
    }

    @GetMapping
    public List<TienCocDTO> getAll() {
        return tienCocService.getAll();
    }

    @GetMapping("/{id}")
    public TienCocDTO getById(@PathVariable Long id) {
        return tienCocService.getById(id);
    }
}
