package com.tnl.frontend;

import com.tnl.entity.ThiSinh;
import com.tnl.entity.ThiSinhKhoiA;
import com.tnl.entity.ThiSinhKhoiB;
import com.tnl.entity.ThiSinhKhoiC;
import com.tnl.entity.TuyenSinh;
import com.tnl.utils.ScannerUtils;

import java.util.ArrayList;

import com.tnl.backend.ITuyenSinh;

public class IMTuyenSinh {

	public static void main(String[] args) {
		
//		ITuyenSinh tuyenSinh = new TuyenSinh();
		TuyenSinh tuyenSinh = new TuyenSinh();
		
		while(true) {
			int act = ScannerUtils.getAction("Hanh dong khong ton tai ! Vui long chon lai !");
			switch(act) {
				case 1:
					String sbd = ScannerUtils.getInfor("Dien so bao danh: ", "So bao danh khong duoc de trong !");
					String hoTen = ScannerUtils.getInfor("Dien ho ten: ", "Ho ten khong duoc de trong !");
					String diaChi = ScannerUtils.getInfor("Dien dia chi: ", "Dia chi khong duoc de trong !");
					int mUT = Integer.parseInt(ScannerUtils.getInfor("Dien muc uu tien: ", "Muc uu tien khong duoc de trong !"));
					int khoithi = Integer.parseInt(ScannerUtils.getInfor("Chon khoi thi: 1. Khoi A | 2. Khoi B | 3. Khoi C: ", "Khoi thi khong duoc de trong !"));
					
					ThiSinh thiSinh;
					switch(khoithi) {
						case 1:
							thiSinh = new ThiSinhKhoiA(sbd, hoTen, diaChi, mUT);
							break;
						case 2:
							thiSinh = new ThiSinhKhoiB(sbd, hoTen, diaChi, mUT);
							break;
						case 3:
							thiSinh = new ThiSinhKhoiC(sbd, hoTen, diaChi, mUT);
							break;
						default:
							System.out.println("Lựa chọn không hợp lệ.");
                            continue;
					}
					
					tuyenSinh.themThiSinh(thiSinh);
					break;
				case 2:
					tuyenSinh.thongTinThiSinh();
					break;
				case 3:
					String searchSbd = ScannerUtils.getInfor("Dien so bao danh: ", "So bao danh khong duoc de trong !");
					ThiSinh ts = tuyenSinh.timThiSinhTheoSBD(searchSbd);
					if (ts != null) {
						System.out.println(ts.toString());
					} else {
						System.out.println("Khong tim thay sinh vien co so bao danh " + searchSbd);
					}
					break;
				case 4:
					tuyenSinh.thoatChuongTrinh();
					break;
				default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
			}
		}
		
	}

	
}
