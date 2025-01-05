package com.gn.practice00.view;

import java.util.Scanner;

import com.gn.practice00.controller.ProjectController;

public class ProjectMenu {
	ProjectController pc = new ProjectController();
	
	public void mainMenu() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("=== 회원 관리 프로그램 ===");
			System.out.println("1. 회원 전체 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 0 : System.out.println("잘가요~안녕~"); return; // 리턴은 이럴때만! 종료시점 강제 지정!
			case 1 : // 회원 추가
				selectMemberAll(); break;
			default : System.out.println("잘못된 번호입니다."); break;
			}
		}
	}
	
	public void selectMemberAll() {
		pc.selectMemberAll();
	}
	
}
