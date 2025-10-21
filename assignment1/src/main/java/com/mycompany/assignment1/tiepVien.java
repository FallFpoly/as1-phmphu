//Name : 
//Mssv : 
//Date : 
//Slide:
package com.mycompany.assignment1;

import java.util.Scanner;

public class tiepVien extends nhanVien {

    private double doanhSo;
    private double hoaHong;

    public tiepVien() {
    }

    public tiepVien(String maNV, String hoTen, double luong, double doanhSo,
            double hoaHong) {
        super(maNV, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    @Override
    public double thuNhap() {
        return super.luong + (this.doanhSo * this.hoaHong);
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap doanh so: ");
        this.doanhSo = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap hoa hong: ");
        this.hoaHong = Double.parseDouble(sc.nextLine()) / 100;
    }

    @Override
    public void xuat() {
        super.xuat(); 
        System.out.printf("MaNV: %s | Ten: %s | Luong CB: %.0f | Doanh so: %.0f | Hoa hong: %.2f | Thu Nhap: %.0f | Thue: %.0f\n",
                this.getMaNV(), this.getHoTen(), this.getLuong(), this.doanhSo, this.hoaHong, this.thuNhap(), this.thue());
    }
    

}
