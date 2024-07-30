package com.lottery.backend;

import java.util.Random;
import java.util.Scanner;

public class Lottery {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] thongTin = thongTinDatCuoc(sc);
		
		
		int giaiDacBiet = thietLapKetQua();
		int[] giaiThuongKhac = new int[10];
		
		for(int i = 0; i < 10; i++) {
			giaiThuongKhac[i] = thietLapKetQua();
			if (giaiThuongKhac[i] == giaiDacBiet) {
				giaiThuongKhac[i] = thietLapKetQua();
			}
		}
		
		
		switch(thongTin[1]) {
			case 1:
				tinhTheoDe(thongTin, giaiDacBiet);
				break;
			case 2:
				tinhTheoLo(thongTin, giaiThuongKhac);
				break;
			default:
				break;
		}
		
	}
	
	public static int[] thongTinDatCuoc(Scanner sc) {
        int soDatCuoc = 0;
        int loaiDatCuoc = 0;
        int soTienCuoc = 0;

        while (true) {
            System.out.print("Nhập số muốn đặt cược có 2 chữ số: ");
            if (sc.hasNextInt()) {
                soDatCuoc = sc.nextInt();
                if (soDatCuoc < 99) {
                	break;
                } else {
                	while (soDatCuoc > 99) {
                		System.out.print("Vui lòng nhập số nhỏ hơn 100: ");
                    	soDatCuoc = sc.nextInt();
                	}
                	break;
                }
            } else {
                System.out.println("Vui lòng nhập một số nguyên.");
                sc.next(); 
            }
        }

        while (true) {
            System.out.print("Lựa chọn loại cược... 1: đề | 2: lô: ");
            if (sc.hasNextInt()) {
                loaiDatCuoc = sc.nextInt();
                if (loaiDatCuoc == 1 || loaiDatCuoc == 2) {
                    break;
                } else {
                    while(loaiDatCuoc != 1 && loaiDatCuoc != 2) {
                    	System.out.print("Vui lòng lựa chọn 1 trong 2 loại cược... 1: đề | 2: lô: ");
                    	loaiDatCuoc = sc.nextInt();
                    }
                    break;
                }
            } else {
                System.out.println("Vui lòng nhập một số nguyên.");
                sc.next(); 
            }
        }

        while (true) {
            System.out.print("Nhập số tiền cược (100,000 ...etc): ");
            if (sc.hasNextInt()) {
                soTienCuoc = sc.nextInt();
                break;
            } else {
                System.out.println("Vui lòng nhập một số nguyên.");
                sc.next(); 
            }
        }

        return new int[]{soDatCuoc, loaiDatCuoc, soTienCuoc};
    }
	
	public static int thietLapKetQua() {
		Random rd = new Random();
		return rd.nextInt(90000) + 10000;
	}
	
	public static void tinhTheoLo(int[] thongTin, int[] giaiThuongKhac) {
		
		int tienThang = 0;
		int count = 0;
		String soDatCuoc = null;
		if (thongTin[0] < 10) {
			soDatCuoc = String.valueOf("0" + thongTin[0]);
			for(int ketQua : giaiThuongKhac) {
				int twoLastDigit = ketQua % 100;
				if ( String.valueOf(twoLastDigit).equals(soDatCuoc)) {
					System.out.println(ketQua);
					count++;
				}
			}
		} else {
			for(int ketQua : giaiThuongKhac) {
				int twoLastDigit = ketQua % 100;
				if (twoLastDigit == thongTin[0]) {
					System.out.println(ketQua);
					count++;
				}
			}
		}
		
		
		tienThang = (thongTin[2] / 23) * 80 * count;
		if (count >= 1) {
			System.out.println("\nBạn đã thắng được " + tienThang + " VND");
		} else {
			System.out.println("\n");
			for (int s : giaiThuongKhac) {
				System.out.println(s);
			}
			
			System.out.println("\nSố đặt cược: " + thongTin[0]);
			System.out.println("Chúc bạn may mắn lần sau !");
		}
	}
	
	public static void tinhTheoDe(int[] thongTin, int giaiDacBiet) {
		
		int tienThang = 0;
		int twoLastDigit = giaiDacBiet % 100;
		
		String soDatCuoc = null;
		if (thongTin[0] < 10) {
			soDatCuoc = String.valueOf("0" + thongTin[0]);
		}
		
		if (String.valueOf(twoLastDigit) == soDatCuoc) {
			System.out.println(giaiDacBiet);
			
			tienThang = thongTin[2] * 70;
			System.out.println("\nBạn đã thắng được " + tienThang + " VND");
		} else {
			System.out.println("\nGiải đặc biệt: " + giaiDacBiet);
			System.out.println("Số đặt cược: " + thongTin[0]);
			System.out.println("Chúc bạn may mắn lần sau !");
		}
	}
}
