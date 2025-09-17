-- =====================================================
-- TẠO DATABASE
-- =====================================================
CREATE DATABASE IF NOT EXISTS nhatro
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE nhatro;

-- =====================================================
-- BẢNG USERS (tài khoản đăng nhập)
-- =====================================================
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE,
    enabled BOOLEAN DEFAULT TRUE
);

-- =====================================================
-- BẢNG ROLES (vai trò)
-- =====================================================
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- =====================================================
-- BẢNG TRUNG GIAN USER_ROLES (quan hệ nhiều-nhiều)
-- =====================================================
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- =====================================================
-- BẢNG KHACH_HANG
-- =====================================================
CREATE TABLE khach_hang (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ten_khach_hang VARCHAR(100) NOT NULL,
    so_dien_thoai VARCHAR(20) NOT NULL UNIQUE,
    ngay_sinh DATE NOT NULL,
    dia_chi VARCHAR(255),
    email VARCHAR(100)
);

-- =====================================================
-- BẢNG PHONG
-- =====================================================
CREATE TABLE phong (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ma_phong VARCHAR(50) NOT NULL UNIQUE,
    loai_phong VARCHAR(100) NOT NULL,
    gia_phong DOUBLE NOT NULL,
    trang_thai VARCHAR(50) NOT NULL, -- "Trống" / "Đang thuê"
    mo_ta VARCHAR(500)
);

-- =====================================================
-- BẢNG HOP_DONG
-- =====================================================
CREATE TABLE hop_dong (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    khach_hang_id BIGINT NOT NULL,
    phong_id BIGINT NOT NULL,
    ngay_bat_dau DATE NOT NULL,
    ngay_ket_thuc DATE,
    tien_dat_coc DOUBLE,
    gia_thue DOUBLE,
    trang_thai VARCHAR(50),
    phuong_thuc_thanh_toan VARCHAR(100),
    ghi_chu VARCHAR(500),
    CONSTRAINT fk_hopdong_khachhang FOREIGN KEY (khach_hang_id) REFERENCES khach_hang(id) ON DELETE CASCADE,
    CONSTRAINT fk_hopdong_phong FOREIGN KEY (phong_id) REFERENCES phong(id) ON DELETE CASCADE
);

-- =====================================================
-- BẢNG HOA_DON
-- =====================================================
CREATE TABLE hoa_don (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    phong_id BIGINT NOT NULL,
    khach_hang_id BIGINT NOT NULL,
    ngay_tao DATE NOT NULL,
    tien_phong DOUBLE DEFAULT 0,
    so_dien INT DEFAULT 0,
    don_gia_dien DOUBLE DEFAULT 0,
    so_nuoc INT DEFAULT 0,
    don_gia_nuoc DOUBLE DEFAULT 0,
    dich_vu_khac DOUBLE DEFAULT 0,
    ma_hoa_don VARCHAR(100),
    tong_tien DOUBLE DEFAULT 0,
    trang_thai VARCHAR(50),
    ghi_chu VARCHAR(500),
    CONSTRAINT fk_hoadon_khachhang FOREIGN KEY (khach_hang_id) REFERENCES khach_hang(id) ON DELETE CASCADE,
    CONSTRAINT fk_hoadon_phong FOREIGN KEY (phong_id) REFERENCES phong(id) ON DELETE CASCADE
);
