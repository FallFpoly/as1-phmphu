/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.assignment1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Assignment1 {

    public static void menu() {
            System.out.println("+------------------------ MENU --------------------------+");
            System.out.println("|1. Nhap danh sach nhan vien                             |");
            System.out.println("|2. Xuat danh sach nhan vien                             |");
            System.out.println("|3. Tim nhan vien                                        |");
            System.out.println("|4. Xoa nhan vien theo ma                                |");
            System.out.println("|5. Cap nhat thong tin nhan vien theo ma                 |");
            System.out.println("|6. Tim cac nhan vien theo khoang luong                  |");
            System.out.println("|7. Sap xep nhan vien theo ho & ten                      |");
            System.out.println("|8. Sap xep nhan vien theo thu nhap                      |");
            System.out.println("|9. Xuat 5 nhan vien có thu nhap cao nhat                |");
            System.out.println("|0. back                                                |");
            System.out.println("+--------------------------------------------------------+");
            
        }
    public static void xulymenu(int chon){
            switch (chon) {
                case 1:
                    System.out.println("Nhap danh sach nhan vien");
                    break;
                case 2:
                    System.out.println("Xuat danh sach nhan vien");
                    break;
                case 3:
                    System.out.println("Tim nhan vien");
                    break;
                case 4:
                    System.out.println("Xoa nhan vien theo ma");
                    break;
                case 5:
                    System.out.println("Cap nhat thong tin nhan vien theo ma");
                    break;
                case 6:
                    System.out.println("Tim cac nhan vien theo khoang luong");
                    break;
                case 7:
                    System.out.println("Sap xep nhan vien theo ho & ten");
                    break;
                case 8:
                    System.out.println("Sap xep nhan vien theo thu nhap");
                    break;
                case 9:
                    System.out.println("Xuat 5 nhan vien co thu nhap cao nhat");
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Vui long chon lai!");
            }
            System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int chon;

        do {
            menu();
            System.out.print("chon chuc nang: ");

            while (!sc.hasNextInt()) {
                System.out.print("!ERROR 404!: ");
                sc.next(); // bỏ qua giá trị sai khi nhập ký tự khác số
            }

            chon = sc.nextInt();
            xulymenu(chon);

        } while (chon != 0);

        sc.close();
    }
}

