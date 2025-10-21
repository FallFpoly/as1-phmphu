//Name : 
//Mssv : 
//Date : 
//Slide:
package com.mycompany.assignment1;

import java.util.Scanner;

public class truongPhong extends nhanVien {

    private double trachNhiem;

    public truongPhong() {
    }

    public truongPhong(String maNV, String hoTen, double luong, double trachNhiem) {
        super(maNV, hoTen, luong);
        this.trachNhiem = trachNhiem;
    }

    @Override
    public double thuNhap() {
        return super.luong + this.trachNhiem;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.println("Nhap tien trach nhiem: ");
        this.trachNhiem = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("MaNV: %s | Ten: %s | Luong CB: %.0f | Trach nhiem: %.0f | Thu Nhap: %.0f | Thue: %.0f\n",
                this.getMaNV(), this.getHoTen(), this.getLuong(), this.trachNhiem, this.thuNhap(), this.thue());
    }

}
