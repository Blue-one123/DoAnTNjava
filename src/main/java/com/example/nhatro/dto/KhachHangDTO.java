
package com.example.nhatro.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class KhachHangDTO {
    private Long id;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(max = 100)
    private String tenKhachHang;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(0[0-9]{9})$", message = "Số điện thoại không hợp lệ")
    private String soDienThoai;
    
    private String ngaySinh;
    
    @Size(max = 200)
    private String diaChi;
    
    @Email
    private String email;
    
    @NotBlank(message = "CCCD không được để trống")
    private String cccd;
}

