package com.example.nhatro.controller;

import com.example.nhatro.dto.KhachHangDTO;
import com.example.nhatro.repository.KhachHangRepository;
import com.example.nhatro.service.KhachHangService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangcontroller {

    private final KhachHangService khachHangService;
    

    @Autowired
    public KhachHangcontroller(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
        
    }
   
    // Lấy toàn bộ khách hàng (không phân trang)
    @GetMapping("/all")
    public ResponseEntity<List<KhachHangDTO>> getAllKhachHangNoPaging() {
    List<KhachHangDTO> result = khachHangService.getAllKhachHangNoPaging();
    return ResponseEntity.ok(result);
    }

    // Lấy danh sách khách hàng (có phân trang)
    @GetMapping
    public ResponseEntity<Page<KhachHangDTO>> getAllKhachHang(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<KhachHangDTO> result = khachHangService.getAllKhachHang(page, size);
        return ResponseEntity.ok(result);
    }

    // Lấy khách hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<KhachHangDTO> getKhachHangById(@PathVariable Long id) {
        KhachHangDTO dto = khachHangService.getKhachHangById(id);
        return ResponseEntity.ok(dto);
    }

    // Tạo mới khách hàng
    @PostMapping
    public ResponseEntity<KhachHangDTO> createKhachHang(@RequestBody KhachHangDTO dto) {
        KhachHangDTO created = khachHangService.createKhachHang(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Cập nhật khách hàng
    @PutMapping("/{id}")
    public ResponseEntity<KhachHangDTO> updateKhachHang(@PathVariable Long id,
                                                        @RequestBody KhachHangDTO dto) {
        KhachHangDTO updated = khachHangService.updateKhachHang(id, dto);
        return ResponseEntity.ok(updated);
    }

    // Xóa khách hàng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhachHang(@PathVariable Long id) {
        khachHangService.deleteKhachHang(id);
        return ResponseEntity.noContent().build();
    }
    //lay kh va id
   @GetMapping("/list-select")
    public ResponseEntity<List<Map<String, Object>>> getKhachHangForSelect() {
    List<Map<String, Object>> result = khachHangService.getAllKhachHangNoPaging()
            .stream()
            .map(kh -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", kh.getId());
                map.put("ten", kh.getTenKhachHang()); // đảm bảo DTO có getTenKhachHang()
                return map;
            })
            .collect(Collectors.toList());

    return ResponseEntity.ok(result);
    }
    //lay kh chua thue phong
    @GetMapping("/list-available")
    public ResponseEntity<List<Map<String, Object>>> getAvailableKhachHangForSelect() {
    List<Map<String, Object>> result = khachHangService.getAvailableKhachHang()
            .stream()
            .map(kh -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", kh.getId());
                map.put("ten", kh.getTenKhachHang());
                return map;
            })
            .collect(Collectors.toList());

    return ResponseEntity.ok(result);
}
}

