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

-- =====================================================
-- DỮ LIỆU MẪU (SEED DATA)
-- =====================================================
INSERT INTO roles (name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

INSERT INTO users (username, password, email, enabled)
VALUES ('admin', '$2a$10$KIXrjH2uFqRjrv7hZcQxKu6yWl3B7T3nPycWjHZQ5Od7N4tC1yM6C', 'admin@example.com', TRUE);
-- password mặc định = "123456" (bcrypt)

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1); -- admin có ROLE_ADMIN

INSERT INTO khach_hang (ten_khach_hang, so_dien_thoai, ngay_sinh, dia_chi, email)
VALUES ('Nguyen Van A', '0912345678', '1995-05-12', 'Hà Nội', 'a@example.com');

INSERT INTO phong (ma_phong, loai_phong, gia_phong, trang_thai, mo_ta)
VALUES ('P101', 'Phòng đơn', 2000000, 'Trống', 'Phòng có ban công');

INSERT INTO hop_dong (khach_hang_id, phong_id, ngay_bat_dau, ngay_ket_thuc, tien_dat_coc, gia_thue, trang_thai, phuong_thuc_thanh_toan, ghi_chu)
VALUES (1, 1, '2025-01-01', '2025-12-31', 2000000, 2000000, 'Đang hiệu lực', 'Chuyển khoản', 'Thanh toán hàng tháng');

INSERT INTO hoa_don (phong_id, khach_hang_id, ngay_tao, tien_phong, so_dien, don_gia_dien, so_nuoc, don_gia_nuoc, dich_vu_khac, ma_hoa_don, tong_tien, trang_thai, ghi_chu)
VALUES (1, 1, '2025-02-01', 2000000, 100, 3500, 10, 15000, 200000, 'HD001', 2000000 + 100*3500 + 10*15000 + 200000, 'Chưa thanh toán', 'Tháng 2/2025');
