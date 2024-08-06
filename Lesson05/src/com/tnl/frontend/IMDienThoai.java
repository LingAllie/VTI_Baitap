package com.tnl.frontend;

import com.tnl.backend.IVuKhi;
import com.tnl.entity.DienThoaiThongMinh;
import com.tnl.entity.DienThoaiCoDien;

public class IMDienThoai {

	public static void main(String[] args) {
		
		IVuKhi vukhi1 = new DienThoaiThongMinh();
		IVuKhi vukhi2 = new DienThoaiCoDien();
		
		vukhi1.tanCongKeXau();
		vukhi2.tanCongKeXau();
	}
}

