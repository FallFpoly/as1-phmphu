/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class AssignmentFinal {
    private static ArrayList<nhanVien> dsNhanVien = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
public static void main(String[] args) {
        int luaChon = 0;

        do {
            System.out.println("\n+------------------ MENU ------------------+");
            System.out.println("| 1. Nhap danh sach nhan vien            |");
            System.out.println("| 2. Xuat danh sach nhan vien            |");
            System.out.println("| 3. Tim va hien thi nhan vien (theo ma) |");
            System.out.println("| 4. Xoa nhan vien (theo ma)               |");
            System.out.println("| 5. Cap nhat thong tin nhan vien (theo ma)|");
            System.out.println("| 6. Tim nhan vien theo khoang luong       |");
            System.out.println("| 7. Sap xep nhan vien theo ho ten         |");
            System.out.println("| 8. Sap xep nhan vien theo thu nhap       |");
            System.out.println("| 9. Xuat 5 nhan vien thu nhap cao nhat    |");
            System.out.println("| 0. Thoat                                 |");
            System.out.println("+------------------------------------------+");
            System.out.print("Moi ban chon chuc nang: ");

            // Bắt lỗi nhập chữ thay vì nhập số (cách đơn giản)
            try {
                String input = sc.nextLine(); // Đọc cả dòng
                luaChon = Integer.parseInt(input); // Chuyển sang số
            } catch (NumberFormatException e) {
                System.out.println("Loi: Phai nhap so tu 0 den 9!");
                luaChon = -1; // Gán 1 số sai để nó lặp lại menu
                continue; // Bỏ qua phần switch-case, lặp lại
            }

            switch (luaChon) {
                case 1:
                    nhapDanhSach();
                    break;
                case 2:
                    xuatDanhSach();
                    break;
                case 3:
                    timNV();
                    break;
                case 4:
                    xoaNV();
                    break;
                case 5:
                    capNhatNV();
                    break;
                case 6:
                    timTheoKhoangLuong();
                    break;
                case 7:
                    sapXepTheoTen();
                    break;
                case 8:
                    sapXepTheoThuNhap();
                    break;
                case 9:
                    xuatTop5();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le. Moi chon lai.");
            }
        } while (luaChon != 0);
    }

    // --- Các hàm chức năng (cũng phải là static) ---

    // CASE 1: Nhập danh sách
    public static void nhapDanhSach() {
        System.out.print("Nhap so luong nhan vien muon them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("---------------------------------");
            System.out.println("Nhap thong tin NV thu " + (i + 1));
            System.out.print("Chon loai NV (1=Hanh chinh, 2=Tiep thi, 3=Truong phong): ");
            int loai = Integer.parseInt(sc.nextLine());
            
            nhanVien nv; // Tạo 1 biến lớp cha

            // Dùng if-else đơn giản
            if (loai == 1) {
                nv = new hanhChinh();
            } else if (loai == 2) {
                nv = new tiepVien(); 
            } else if (loai == 3) {
                nv = new truongPhong(); 
            } else {
                System.out.println("Chon sai, tu dong chon Hanh chinh.");
                nv = new hanhChinh();
            }
            
            nv.nhap(sc); // Gọi hàm nhap() của lớp tương ứng
            dsNhanVien.add(nv); // Thêm vào danh sách
        }
    }

    // CASE 2: Xuất danh sách
    public static void xuatDanhSach() {
        System.out.println("--- DANH SACH NHAN VIEN ---");
        if (dsNhanVien.isEmpty()) { // isEmpty() là hàm kiểm tra ArrayList có rỗng không
            System.out.println("Danh sach rong, khong co gi de xuat.");
            return; // Dừng hàm
        }
        
        // Dùng vòng lặp for-each
        for (nhanVien nv : dsNhanVien) {
            nv.xuat(); // Gọi hàm xuat() của từng nhân viên
        }
    }

    // CASE 3: Tìm NV theo mã
    public static void timNV() {
        System.out.print("Nhap ma NV can tim: ");
        String maTim = sc.nextLine();
        
        nhanVien nvTimThay = null; // Tạo 1 biến để lưu NV tìm được

        // Dùng vòng lặp for-each để tìm
        for (nhanVien nv : dsNhanVien) {
            // Dùng equalsIgnoreCase để không phân biệt chữ hoa/thường
            if (nv.getMaNV().equalsIgnoreCase(maTim)) {
                nvTimThay = nv;
                break; // Tìm thấy thì dừng vòng lặp
            }
        }
        
        if (nvTimThay != null) { // Nếu tìm thấy (biến không còn là null)
            System.out.println("Tim thay nhan vien:");
            nvTimThay.xuat();
        } else {
            System.out.println("Khong tim thay nhan vien co ma: " + maTim);
        }
    }

    // CASE 4: Xóa NV theo mã
    public static void xoaNV() {
        System.out.print("Nhap ma NV can xoa: ");
        String maXoa = sc.nextLine();
        
        nhanVien nvCanXoa = null;

        for (nhanVien nv : dsNhanVien) {
            if (nv.getMaNV().equalsIgnoreCase(maXoa)) {
                nvCanXoa = nv;
                break; 
            }
        }
        
        if (nvCanXoa != null) {
            dsNhanVien.remove(nvCanXoa); // Xóa đối tượng khỏi ArrayList
            System.out.println("Da xoa nhan vien co ma: " + maXoa);
        } else {
            System.out.println("Khong tim thay nhan vien de xoa.");
        }
    }

    // CASE 5: Cập nhật NV theo mã
    public static void capNhatNV() {
        System.out.print("Nhap ma NV can cap nhat: ");
        String maSua = sc.nextLine();
        
        nhanVien nvCanSua = null;
        for (nhanVien nv : dsNhanVien) {
            if (nv.getMaNV().equalsIgnoreCase(maSua)) {
                nvCanSua = nv;
                break; 
            }
        }
        
        if (nvCanSua != null) {
            System.out.println("Tim thay NV. Moi nhap lai toan bo thong tin cho NV:");
            // Chỉ cần gọi lại hàm nhap() của chính nó
            // Java sẽ tự biết gọi hàm nhap() của TiepThi hay TruongPhong
            nvCanSua.nhap(sc); 
            System.out.println("Da cap nhat thong tin.");
        } else {
            System.out.println("Khong tim thay nhan vien de cap nhat.");
        }
    }

    // CASE 6: Tìm NV theo khoảng lương (dùng thu nhập)
    public static void timTheoKhoangLuong() {
        System.out.print("Nhap thu nhap toi thieu: ");
        double min = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap thu nhap toi da: ");
        double max = Double.parseDouble(sc.nextLine());
        
        System.out.printf("--- DS NV CO THU NHAP TU %.0f DEN %.0f ---\n", min, max);
        boolean timThay = false; 
        
        for (nhanVien nv : dsNhanVien) {
            // Dùng hàm thuNhap() của bạn
            if (nv.thuNhap() >= min && nv.thuNhap() <= max) {
                nv.xuat();
                timThay = true;
            }
        }
        
        if (timThay == false) { 
            System.out.println("Khong tim thay nhan vien nao trong khoang luong nay.");
        }
    }

    // CASE 7: Sắp xếp theo Tên
    public static void sapXepTheoTen() {
        // Đây là cách viết cơ bản (dùng lớp nặc danh)
        Comparator<nhanVien> comp = new Comparator<nhanVien>() {
            @Override
            public int compare(nhanVien nv1, nhanVien nv2) {
                // So sánh 2 chuỗi (Tên)
                return nv1.getHoTen().compareTo(nv2.getHoTen());
            }
        };
        
        Collections.sort(dsNhanVien, comp);
        System.out.println("Da sap xep danh sach theo ten.");
        xuatDanhSach(); // Gọi lại hàm xuất để xem kết quả
    }

    // CASE 8: Sắp xếp theo Thu Nhập (giảm dần)
    public static void sapXepTheoThuNhap() {
        Comparator<nhanVien> comp = new Comparator<nhanVien>() {
            @Override
            public int compare(nhanVien nv1, nhanVien nv2) {
                // So sánh 2 số double (Thu nhập)
                // Viết tường minh cho dễ hiểu
                if (nv1.thuNhap() > nv2.thuNhap()) {
                    return -1; // Giảm dần: Lớn hơn thì xếp trước (return -1)
                } else if (nv1.thuNhap() < nv2.thuNhap()) {
                    return 1; // Nhỏ hơn thì xếp sau (return 1)
                } else {
                    return 0; // Bằng nhau thì giữ nguyên
                }
                
            }
        };
        
        Collections.sort(dsNhanVien, comp);
        System.out.println("Da sap xep danh sach theo thu nhap (giam dan).");
        xuatDanhSach();
    }

    // CASE 9: Xuất Top 5
    public static void xuatTop5() {
        // Đầu tiên, phải sắp xếp giảm dần (giống hệt case 8)
        Comparator<nhanVien> comp = new Comparator<nhanVien>() {
            @Override
            public int compare(nhanVien nv1, nhanVien nv2) {
                if (nv1.thuNhap() > nv2.thuNhap()) return -1;
                else if (nv1.thuNhap() < nv2.thuNhap()) return 1;
                else return 0;
            }
        };
        Collections.sort(dsNhanVien, comp);
        
        System.out.println("--- TOP 5 NHAN VIEN THU NHAP CAO NHAT ---");
        
        // Kiểm tra xem danh sách có đủ 5 người không
        int soLuong = 5;
        if (dsNhanVien.size() < 5) {
            soLuong = dsNhanVien.size(); // Nếu không đủ 5, thì chỉ lấy hết danh sách
        }
        
        // Dùng vòng lặp for (i) để lấy đúng 'soLuong' phần tử đầu tiên
        for (int i = 0; i < soLuong; i++) {
            dsNhanVien.get(i).xuat(); // get(i) là lấy phần tử ở vị trí i
        }
        
        if (dsNhanVien.isEmpty()) {
            System.out.println("Danh sach rong.");
        }
    }    

}

