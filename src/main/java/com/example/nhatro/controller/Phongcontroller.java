package com.example.nhatro.controller;

import com.example.nhatro.dto.PhongDTO;
import com.example.nhatro.entity.Phong;
import com.example.nhatro.repository.PhongRepository;
import com.example.nhatro.service.PhongService;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.nio.file.*;

@RestController
@RequestMapping("/api/phong")
public class Phongcontroller {

    @Autowired
    private PhongService phongService;
    @Autowired
    private PhongRepository phongRepository;
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
    // ✅ Upload ảnh cho phòng
    @PostMapping("/upload/{id}")
    public ResponseEntity<?> uploadAnhPhong(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
    try {
        // Thư mục chứa ảnh (Frontend/public/images)
        String uploadDir = "D:/Code visual/DoAn-nhatrof/Frontend/public/images/";

        // Tạo tên file duy nhất (tránh trùng)
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Nơi lưu file
        Path path = Paths.get(uploadDir + fileName);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        
        Phong phong = phongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));

        phong.setAnhPhong("/images/" + fileName);

        // 👉 chỉ update anhPhong, giữ nguyên khach_hang_id và các field khác
        phongRepository.saveAndFlush(phong);
        // Gọi service để cập nhật đường dẫn ảnh cho phòng
        PhongDTO phongDTO = phongService.updateAnhPhong(id, "/images/" + fileName);

        return ResponseEntity.ok(phongDTO);
    } catch (Exception e) {
        return ResponseEntity.internalServerError().body("Lỗi upload ảnh: " + e.getMessage());
    }
}


    // ✅ API cho select phòng còn trống (id + mã phòng + giá)
    @GetMapping("/list-available")
    public ResponseEntity<List<Map<String, Object>>> getAvailablePhongForSelect() {
        List<Map<String, Object>> result = phongService.getAvailablePhong() // ⚡ gọi qua instance
                .stream()
                .map(phong -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", phong.getId());
                    map.put("maPhong", phong.getMaPhong());
                    map.put("giaPhong", phong.getGiaPhong()); // trả luôn giá phòng
                    return map;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}
