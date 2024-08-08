package com.tnl.frontend;

import java.util.Random;

import com.tnl.utils.ScannerUtils;

public class Program {

	public static void main(String[] args) throws Exception {
		System.out.println("Chào mừng bạn đến với trò chơi đoán số!");
		System.out.println("------ ------ ------ ------ ------ ------");
		boolean replay = false;
		replay = StartGame();
		while(replay) {
			System.out.println("\nBạn có muốn chơi lại hay không ? 1. Có | 2. Không");
			int choice = ScannerUtils.getNumber("Lựa chọn của bạn là: ");
			switch(choice) {
			case 1:
				StartGame();
				break;
			case 2:
				System.out.println("\nKết thúc trò chơi. Hẹn gặp lại... !");
				return;
			default:
				System.out.println("Lựa chọn không hợp lệ !");
				break;
			}
		}
	}

	private static boolean StartGame() throws Exception {
		Random rand = new Random();
		int randNum = rand.nextInt(101);
		System.out.println("\nTôi đang nghĩ đến một số từ 1 đến 100.");
		while(true) {
			
			int guessNum = ScannerUtils.getNumber("Nhập số bạn đoán: ");
			
			if(guessNum < randNum) {
				System.out.println("Số bạn đoán nhỏ hơn số tôi đang nghĩ ...\n");
			} else if (guessNum > randNum) {
				System.out.println("Số bạn đoán lớn hơn số tôi đang nghĩ ...\n");
			} else {
				System.out.println("\nSố của tôi: " + randNum);
				System.out.println("Chúc mừng bạn đã đoán đúng con số !!!");
				break;
			}
		}
		
		return true;
	}
}
