package com.gn.homework01.view;

import java.util.List;
import java.util.Scanner;

import com.gn.homework01.controller.MarketBuyController;
import com.gn.homework01.controller.MarketController;
import com.gn.homework01.controller.MarketProductController;
import com.gn.homework01.model.vo.MarketBuyVo;
import com.gn.homework01.model.vo.MarketProductVo;
import com.gn.homework01.model.vo.MarketUserVo;

public class MarketMenu {
	private Scanner sc = new Scanner(System.in);
	private MarketController mc = new MarketController();
	private MarketProductController mpc = new MarketProductController();
	private MarketBuyController mbc = new MarketBuyController();
	
//	메인 메뉴
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
				case 2 : login(); break;
				case 3 : managerMenu(); break;
				case 0 : System.out.println("이용해주셔서 감사합니다."); return;
				default : System.out.println("메뉴를 잘못 입력하셨습니다.");
			}
		}
	}
	
//	회원가입
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
	
//	유저, 관리자 로그인
	public void login() {
		System.out.println("*** 로그인 ***");
		System.out.println("아이디, 비밀번호를 입력해주세요.");
		System.out.print("아이디 : ");
		String loginId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String loginPw = sc.nextLine();
		MarketUserVo smu = mc.login(loginId, loginPw);
		if(smu == null) {
			System.out.println("잘못된 아이디 또는 비밀번호입니다.");
		} else if(smu.getUserNo() == 1 && smu.getUserNick().equals("관리자")) {
			managerMenu();
		} else {
			userMenu(smu);
		}
	}
	
//	관리자 로그인 -> 관리자 메뉴
	public void managerMenu() {
		while(true) {
			System.out.println("=== 관리자 메뉴 ===");
			System.out.println("1. 제품 등록");
			System.out.println("2. 제품 입고");
			System.out.println("3. 판매 현황");
			System.out.println("4. 재고 현황");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1 : createProduct(); break;
			case 2 : importProduct(); break;
			case 3 : situationProduct(); break;
			case 4 : searchProductTable(); break;
			case 0 : System.out.println("관리자 메뉴를 종료합니다."); return;
			default : System.out.println("관리자 메뉴를 잘못 입력하셨습니다.");
			}
		}
	}
	
	
//	관리자 로그인 -> 관리자 메뉴 -> 제품 등록
	public void createProduct() {
		System.out.println("*** 제품 등록 ***");
		System.out.println("제품명, 제품 가격, 입고 개수를 입력해주세요.");
		System.out.print("제품명 : ");
		String createpName = sc.nextLine();
		System.out.print("제품 가격 : ");
		int createpPrice = sc.nextInt();
		System.out.print("입고 개수 : ");
		int createpImport = sc.nextInt();
		sc.nextLine();
		int result = mpc.createProduct(createpName, createpPrice, createpImport);
		if(result > 0) {
			System.out.println("*제품 등록이 완료되었습니다.*");
			System.out.println("제품명 : " + createpName);
			System.out.println("제품 가격 : " + createpPrice + " 원");
			System.out.println("입고 개수 : " + createpImport + " 개");
		} else {
			System.out.println("제품 등록이 실패했습니다.");
		}
	}
//	관리자 로그인 -> 관리자 메뉴 -> 제품 입고
	public void importProduct() {
		System.out.println("*** 제품 입고 ***");
		System.out.println("제품 번호, 입고 개수를 입력해주세요.");
		System.out.print("제품 번호 : ");
		int importpNo = sc.nextInt();
		System.out.print("입고 개수 : ");
		int importpImport = sc.nextInt();
		sc.nextLine();
		int result = mpc.importProduct(importpNo, importpImport);
		if(result > 0) {
			System.out.println("*제품 입고가 완료되었습니다.*");
			System.out.println("제품 번호 : " + importpNo);
			System.out.println("입고 개수 : " + importpImport + " 개");
		} else {
			System.out.println("제품 입고가 실패했습니다.");
		}
	}
//	관리자 로그인 -> 관리자 메뉴 -> 판매 현황
	public void situationProduct() {
		System.out.println("*** 판매 현황 ***");
		List<MarketBuyVo> list = mbc.searchBuyTable();
		if(list.isEmpty()) {
			System.out.println("판매 이력이 없습니다.");
		} else {
			for(MarketBuyVo l : list) {
				System.out.println(l);
			}
		}
	}
//	관리자 로그인 -> 관리자 메뉴 -> 재고 현황
	public void searchProductTable() {
		List<MarketProductVo> list = mpc.searchProductTable();
		for(MarketProductVo l : list) {
			System.out.println(l);
		}
	}
	
	
//	유저 로그인 -> 유저 메뉴
	public void userMenu(MarketUserVo smu) {
		System.out.println("=== " + smu.getUserNick() + "님 환영합니다! ===");
		while(true) {
			System.out.println("1. 제품 구매");
			System.out.println("2. 개인 정보 수정");
			System.out.println("3. 탈퇴");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1 : userBuyProduct(smu); break;
			case 2 : editeNick(smu); break;
			case 3 : deleteUser(smu); return;
			case 0 : System.out.println("로그아웃"); return;
			default : System.out.println("메뉴를 잘못 입력하셨습니다.");
			}
		}
	}
//	유저 로그인 -> 유저 메뉴 -> 제품 구매
	public void userBuyProduct(MarketUserVo smu) {
		System.out.println("*** 제품 구매 ***");
		List<MarketProductVo> list = mpc.searchProductTable();
		if(list.isEmpty()) {
			System.out.println("구매 가능한 제품이 없습니다.");
		} else {
			for(MarketProductVo l : list) {
				System.out.println(l);
			}
			System.out.println("구매하려는 제품의 제품 번호, 구매 개수를 입력해주세요.");
			System.out.print("제품 번호 : ");
			int userpNo = sc.nextInt();
			System.out.print("구매 개수 : ");
			int userpSales = sc.nextInt();
			sc.nextLine();
			int result = mbc.userBuyProduct(userpNo, userpSales, smu.getUserNo());
			if(result == -10) {
				System.out.println("재고가 부족합니다.");
			} else if(result > 0) {
				System.out.println("구매 완료했습니다.");
			} else {
				System.out.println("구매 실패했습니다.");
			}
		}
	}
//	유저 로그인 -> 유저 메뉴 -> 닉네임 변경
	public void editeNick(MarketUserVo smu) {
		System.out.println("*** 닉네임 수정 ***");
		System.out.println("비밀번호를 입력해주세요.");
		System.out.print("비밀번호 : ");
		String oldPw = sc.nextLine();
		if(oldPw.equals(smu.getUserPw())) {
			System.out.println("새로운 닉네임을 입력해주세요.");
			System.out.print("닉네임 : ");
			String newNick = sc.nextLine();
			int result = mc.editeNick(smu.getUserId(), newNick);
			if(result > 0) {
				System.out.println("닉네임 변경이 완료되었습니다.");
			} else {
				System.out.println("닉네임 변경이 실패하였습니다.");
			}
		}
	}
//	유저 로그인 -> 유저 메뉴 -> 탈퇴
	public void deleteUser(MarketUserVo smu) {
		System.out.println("*** 회원 탈퇴 ***");
		System.out.println("비밀번호를 입력해주세요.");
		System.out.print("비밀번호 : ");
		String oldPw = sc.nextLine();
		if(oldPw.equals(smu.getUserPw())) {
			System.out.print("정말 탈퇴하시겠습니까?(Y/N) : ");
			String yn = sc.nextLine().toUpperCase();
			if(yn.equals("Y")) {
				int result = mc.deleteUser(smu.getUserId());
				if(result > 0) {
					System.out.println("회원 탈퇴가 되었습니다.");
				} else {
					System.out.println("회원 탈퇴가 실패했습니다.");
				}
			}
		}
	}
	
	
	
}
