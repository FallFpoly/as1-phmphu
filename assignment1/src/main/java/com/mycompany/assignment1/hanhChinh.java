//Name : 
//Mssv : 
//Date : 
//Slide:
package com.mycompany.assignment1;

import java.util.Scanner;

public class hanhChinh extends nhanVien {

    public hanhChinh(String maNV, String hoTen, double luong) {
        super(maNV, hoTen, luong);
    }

    public hanhChinh() {
    }
    

    @Override
    public double thuNhap() {
        return super.luong;
    }

}
