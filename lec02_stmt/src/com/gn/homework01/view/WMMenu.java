package com.gn.homework01.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.gn.homework01.controller.WMController;
import com.gn.homework01.vo.WMSong;
import com.gn.homework01.vo.WMUser;

public class WMMenu {
	WMController c = new WMController();
	Scanner sc = new Scanner(System.in);
	private String wmid = null;
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 초기 메뉴 ===");
			System.out.println("0. 종료");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.print("메뉴 선택 : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 0 : System.out.println("=== 프로그램 종료 ==="); return;
			case 1 : joinMember(); break;
			case 2 : login(); break;
//			case 123 : managerMenu(); break;
//			case 456 : userMenu(); break;
			default : System.out.println("잘못된 번호입니다.~~"); break;
			}
			
		}
	}
	
	public void joinMember() {
		System.out.println("=== 회원가입 ===");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		int result = c.joinMember(id, pw, name);
		if(result > 0) {
			System.out.println("성공적으로 가입 되었습니다.");
		} else {
			System.out.println("가입에 실패하였습니다.(아이디 중복)");
		}
	}
	
	public void login() {
		System.out.println("=== 로그인 ===");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		this.wmid = id;
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		WMUser wmu = c.login(id, pw);
		if(wmu == null) {
			System.out.println("잘못된 아이디 또는 비밀번호입니다.");
		} else if(wmu.getU_no() == 1 && wmu.getU_name().contains("관리자")) {
			managerMenu();
		} else if(wmu.getU_no() != 1) {
			userMenu();
		}
	}
	
	public void managerMenu() {
		while(true) {
			System.out.println("=== 관리자 메뉴 ===");
			System.out.println("0. 종료");
			System.out.println("1. 음악 추가");
			System.out.println("2. 음악 인기 순위 조회");
			System.out.print("메뉴 선택 : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 0 : System.out.println("=== 로그아웃 ==="); return;
			case 1 : addPlayList(); break;
			case 2 : searchTopSong(); break;
			default : System.out.println("잘못된 번호입니다.```"); break;
			}
			
		}
		
	}
	
	public void addPlayList() {
		System.out.println("=== 음악 추가 ===");
		System.out.print("음악 제목 : ");
		String title = sc.nextLine();
		System.out.print("아티스트명 : ");
		String artist = sc.nextLine();
		int result = c.addPlayList(title, artist);
		if(result > 0) {
			System.out.println("성공적으로 추가 되었습니다.");
		} else {
			System.out.println("추가 실패하였습니다.");
		}
	}
	
	public void searchTopSong() {
		System.out.println("=== 인기 TOP 10 ===");
		List<WMSong> list = c.searchTopSong();
		if(list.isEmpty()) {
			System.out.println("플레이리스트가 비어있습니다.");
		} else {
			for(int i = 0; i < list.size(); i ++) {
				System.out.println("=" + (i+1) + "등= " + list.get(i));
			}
//			for(WMSong l : list) {
//				System.out.println(l);
//			}
		}
	}
	
	
	
	
		
	public void userMenu() {
		while(true) {
			System.out.println("=== 사용자 메뉴 ===");
			System.out.println("0. 종료");
			System.out.println("1. 음악 재생");
			System.out.println("2. 개인 정보 수정");
			System.out.println("3. 회원 탈퇴");
			System.out.print("메뉴 선택 : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 0 : System.out.println("=== 로그아웃 ==="); return;
			case 1 : playSong(); break;
			case 2 : changeUserName(); break;
			case 3 : deleteId(); return;
			default : System.out.println("잘못된 번호입니다.```"); break;
			}
			
		}
	}
	
	public void playSong() {
		searchAllSong();
		System.out.print("재생할 음악 번호 : ");
		int songNum = sc.nextInt();
		sc.nextLine();
		int result = selectSongNum(songNum);
		if(result > 0) {
			WMSong wms = songData(songNum);
			System.out.println("*** " + songNum + "번 ***");
			System.out.println("제목 : " + wms.getS_title());
			System.out.println("가수 : " + wms.getS_artist());
			System.out.println("재생 횟수 : " + wms.getS_count());
			System.out.println("*** 재생 성공 ***");
		} else {
			System.out.println("재생 실패");
		}
	}
	
	
	
	public void searchAllSong() {
		System.out.println("=== 음악 재생 ===");
		List<WMSong> list = c.searchAllSong();
//		Collections.sort(list);
		if(list.isEmpty()) {
			System.out.println("목록이 비어있습니다.");
		} else {
//			for(int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
//			}
			for(WMSong l : list) {
				System.out.println(l);
			}
		}
	}
	
	
	
	public int selectSongNum(int songNum) {
		int result = c.selectSongNum(songNum);
		return result;
	}
		
	public void changeUserName() {
		System.out.print("비밀번호를 입력해주세요. : ");
		String wmpw = sc.nextLine();
		WMUser wmu = c.login(wmid, wmpw);
		if(wmu == null) {
			System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
		} else {
			System.out.print("변경할 이름 : ");
			String newName = sc.nextLine();
			int result = c.changeUserName(newName, wmid, wmpw);
			if(result > 0) {
				System.out.println("이름 변경 성공!");
			} else {
				System.out.println("이름 변경 실패..");
			}
		}
		
	}
	
	public void deleteId() {
		System.out.print("비밀번호를 입력해주세요. : ");
		String wmpw = sc.nextLine();
		WMUser wmu = c.login(wmid, wmpw);
		if(wmu == null) {
			System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
		} else {
			System.out.print("탈퇴하시겠습니까?(Y/N) : ");
			String yn = sc.nextLine().toUpperCase();
			if(yn.equals("Y")) {
				int result = c.deleteId(wmid, wmpw);
				if(result > 0) {
					System.out.println("탈퇴 완료");
				} else {
					System.out.println("탈퇴 실패");
				}
			} else if(yn.equals("N")) {
				System.out.println("탈퇴를 취소합니다.");
			}
		}
	}
	
	
	public WMSong songData(int songNo) {
		return c.songData(songNo);
	}
		
		
	
}
