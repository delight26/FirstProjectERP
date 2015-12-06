package com.firstproject.visitant;

import java.util.ArrayList;

public class AdminList {




	public ArrayList<Integer> adminList() {
		ArrayList<Integer> visitant = new ArrayList<Integer>();
		//정문 출입 담당자
		visitant.add(10021);
		visitant.add(20032);
		visitant.add(20045);
		//보안구역 출입 담당자
		visitant.add(20022);
		visitant.add(10044);
		visitant.add(10035);
		return visitant;
	}
}
