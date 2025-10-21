//Name : 
//Mssv : 
//Date : 
//Slide:
package com.mycompany.assignment1;

import java.util.Scanner;

public class nhanVien {

    protected String maNV;
    protected String hoTen;
    protected double luong;

    public nhanVien() {

    }

    public nhanVien(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    //nhap
    public void nhap(Scanner sc) {
        
        System.out.print("nhap ma nv: ");
        this.maNV = sc.nextLine();
        System.out.print("nhap ho & ten: ");
        this.hoTen = sc.nextLine();
        System.out.print("luong: ");
        this.luong = Double.parseDouble(sc.nextLine());
        sc.nextLine();
    }

    //xuat
    public void xuat() {
        System.out.printf("MaNV: %s | Ten: %s | Luong CB: %.0f | Thu Nhap: %.0f | Thue: %.0f (Loai: Hanh Chinh)\n",
                this.getMaNV(), this.getHoTen(), this.getLuong(), this.thuNhap(), this.thue());
    }

    //thu nhap
    public double thuNhap() {
        return this.getLuong();
    }

    //thue
    public double thue() {
        if (thuNhap() < 9000000) {
            return 0;
        } else if (thuNhap() >= 9000000 && thuNhap() < 15000000) {
            return this.thuNhap() * 10 / 100;
        } else {
            return this.thuNhap() * 12 / 100;
        }
    }

}
