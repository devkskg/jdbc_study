package com.gn.study.run;

import com.gn.study.view.ProjectMenu;

public class Run {
	public static void main(String[] args) {
//		실행 담당 -> 메인 메소드 반드시 포함
//		ProjectMenu pm = new ProjectMenu();
//		pm.mainMenu();
		new ProjectMenu().mainMenu(); // -> 반환형 void, 매개변수 x 라는 정보도 얻을 수 있다.
	}
}
