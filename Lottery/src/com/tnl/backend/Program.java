package com.tnl.backend;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.tnl.entity.LotteryResult;
import com.tnl.utils.ScannerUtils;

public class Program {

	public static void main(String[] args) {
		
		List<LotteryResult> lotteryResults = khoiTaoBangLottery();
		String ngayQT = ScannerUtils.nhapNgayQuayThuong();
		int[] thongTinDatCuoc = ScannerUtils.nhapThongTinDatCuoc();
		
		switch(thongTinDatCuoc[1]) {
			case 1:
				tinhTheoDe(ngayQT, lotteryResults, thongTinDatCuoc);
				break;
			case 2:
				tinhTheoLo(ngayQT, lotteryResults, thongTinDatCuoc);
				break;
			default:
				break;
		}
	}
	
	private static List<LotteryResult> khoiTaoBangLottery() {
		List<LotteryResult> listLotteryResults = new ArrayList<>();
		
//		String ngayQT = "24/07/2024";
//		String giaiDB = taoGiaiRandom(6);
//        String giaiNhat = taoGiaiRandom(5);
//        String giaiNhi = taoGiaiRandom(5);
//        String[] giaiBa = {taoGiaiRandom(5), taoGiaiRandom(5)};
//        String[] giaiTu = {taoGiaiRandom(5), taoGiaiRandom(5), taoGiaiRandom(5), taoGiaiRandom(5), taoGiaiRandom(5), taoGiaiRandom(5), taoGiaiRandom(5)};
//        String giaiNam = taoGiaiRandom(4);
//        String[] giaiSau = {taoGiaiRandom(4), taoGiaiRandom(4), taoGiaiRandom(4)};
//        String giaiBay = taoGiaiRandom(3);
//        String giaiTam = taoGiaiRandom(2);
//		
//		LotteryResult result = new LotteryResult(
//	            ngayQT,
//	            giaiDB,
//	            giaiNhat,
//	            giaiNhi,
//	            giaiBa,
//	            giaiTu,
//	            giaiNam,
//	            giaiSau,
//	            giaiBay,
//	            giaiTam
//	        );
		
		LotteryResult result = new LotteryResult();
		result.setNgayQT("24/07/2024");
		result.setGiaiDB("123456");
		result.setGiaiNhat("09876");
		result.setGiaiNhi("72364");
		String[] giaiBa = {"92759", "82744"};
		result.setGiaiBa(giaiBa);
		String[] giaiTu = {"82749", "05736", "92744", "56485", "06845", "62834", "75378"};
		result.setGiaiTu(giaiTu);
		result.setGiaiNam("5320");
		String[] giaiSau = {"2723", "5987", "7654"};
		result.setGiaiSau(giaiSau);
		result.setGiaiBay("099");
		result.setGiaiTam("09");
		
		listLotteryResults.add(result);
		
		return listLotteryResults;
	}
	
	public static String taoGiaiRandom(int length) {
		Random rd = new Random();
        int maxValue = (int) Math.pow(10, length);
        int rand = rd.nextInt(maxValue);
		
		if (length == 6 && rand < 100000) {
			return String.format("%0" + length + "d", rand);
		} else if (length == 5 && rand < 10000) {
			return String.format("%0" + length + "d", rand);
		} else if (length == 4 && rand < 1000) {
			return String.format("%0" + length + "d", rand);
		} else if (length == 3 && rand < 100) {
			return String.format("%0" + length + "d", rand);
		} else if (length == 2 && rand < 10) {
			return String.format("%0" + length + "d", rand);
		} else {
			return String.valueOf(rand);
		}
	}
	
	public static void tinhTheoLo(String ngayQT, List<LotteryResult> listLotteryResults, int[] thongTinDatCuoc) {
		
		int tienThang = 0;
		int count = 0;
		String soDatCuoc = String.format("%02d", thongTinDatCuoc[0]);
		
		for (LotteryResult lotteryResult : listLotteryResults) {
			if (ngayQT.equals(lotteryResult.getNgayQT())) {
				if (lotteryResult.getGiaiNhat().endsWith(soDatCuoc) ||
	                    lotteryResult.getGiaiNhi().endsWith(soDatCuoc) ||
	                    lotteryResult.getGiaiNam().endsWith(soDatCuoc) ||
	                    lotteryResult.getGiaiBay().endsWith(soDatCuoc) ||
	                    lotteryResult.getGiaiTam().equals(soDatCuoc)) {
					count++;
				} else {
					for(String num : lotteryResult.getGiaiBa()) {
						if (num.endsWith(soDatCuoc) ) {
							count++;
						}
					}
					
					for(String num : lotteryResult.getGiaiTu()) {
						if (num.endsWith(soDatCuoc) ) {
							count++;
						}
					}
					
					for(String num : lotteryResult.getGiaiSau()) {
						if (num.endsWith(soDatCuoc) ) {
							count++;
						}
					}
				}
			} else {
				System.out.println("Ngày " + ngayQT + " không tìm thấy kết quả !");
				return;
			}
		}
		
		tienThang = (thongTinDatCuoc[2] / 23) * 80 * count;
		if (count > 0) {
			for (LotteryResult lotteryResult : listLotteryResults) {
		        System.out.println(lotteryResult.toString());
		    }
			NumberFormat numberFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
	        String formattedTienThang = numberFormat.format(tienThang);
	        System.out.println("\nBạn đã thắng được " + formattedTienThang + " VND");
		} else {
			System.out.println("\n");
			for (LotteryResult lotteryResult : listLotteryResults) {
		        System.out.println(lotteryResult.toString());
		    }
			
			System.out.println("\nSố đặt cược: " + thongTinDatCuoc[0]);
			System.out.println("Chúc bạn may mắn lần sau !");
		}
	}
	
	public static void tinhTheoDe(String ngayQT, List<LotteryResult> listLotteryResults, int[] thongTinDatCuoc) {
		
		int tienThang = 0;
		 String soDatCuoc = String.format("%02d", thongTinDatCuoc[0]);
	
		for (LotteryResult lotteryResult : listLotteryResults) {
			if (ngayQT.equals(lotteryResult.getNgayQT())) {
				if (lotteryResult.getGiaiDB().substring(4, 6).equals(soDatCuoc)) {
					System.out.println(lotteryResult.toString());
					
					tienThang = thongTinDatCuoc[2] * 70;
					NumberFormat numberFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
			        String formattedTienThang = numberFormat.format(tienThang);
			        System.out.println("\nBạn đã thắng được " + formattedTienThang + " VND");
				} else {
					System.out.println(lotteryResult.toString());
					System.out.println("Số đặt cược: " + thongTinDatCuoc[0]);
					System.out.println("Chúc bạn may mắn lần sau !");
				}
			} else {
				System.out.println("Ngày " + ngayQT + " không tìm thấy kết quả !");
				return;
			}
		}
	}
	
	

}
