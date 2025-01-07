package com.gn.homework01.view;

import java.util.Scanner;

import com.gn.homework01.controller.MarketController;

public class MarketMenu {
	private Scanner sc = new Scanner(System.in);
	MarketController mc = new MarketController();
	
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("=== (주)ABC 프로젝트 관리 시스템 ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : createUser(); break;
				case 2 : break;
				case 0 : System.out.println("이용해주셔서 감사합니다."); return;
				default : System.out.println("메뉴를 잘못 입력하셨습니다.");
			}
		}
	}
	
	public void createUser() {
		System.out.println("*** 회원가입 페이지 ***");
		System.out.println("사용하실 아이디, 비밀번호, 닉네임을 입력해주세요.");
		System.out.print("아이디 : ");
		String createId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String createPw = sc.nextLine();
		System.out.print("닉네임 : ");
		String createNick = sc.nextLine();
		
		int result = mc.createUser(createId, createPw, createNick);
		if(result > 0) {
			System.out.println("*회원가입이 완료되었습니다.*");
			System.out.println("아이디 : " + createId);
			System.out.println("비밀번호 : " + createPw);
			System.out.println("닉네임 : " + createNick);
		} else {
			System.out.println("회원가입에 실패했습니다.");
		}
		
	}
	
	
	
	
	
	
	
	
	
}
