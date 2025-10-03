
package com.example.nhatro.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PhongDTO {
    private Long id;
    
    private String maPhong;

    @NotBlank
    private String loaiPhong;

    @NotNull @Min(0)
    private Double giaPhong;

    @NotBlank
    private String trangThai; // "Trống" / "Đang thuê"

    @Size(max = 500)
    private String moTa;
    private String anhPhong;
}
