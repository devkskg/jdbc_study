package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.Controller;
import com.gn.study.model.vo.Car;

//	사용자가 보게 될 화면을 구성
//	- 사용자에게 정보 입력 받기
//	- 결과 화면 출력
public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 자동차 정보 관리 시스템 ===");
			System.out.println("1. 추가");
			System.out.println("2. 목록 조회");
			System.out.println("3. 단일 조회");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("0. 종료");
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1 : insertCarOne(); break;
				case 2 : selectCarAll(); break;
				case 3 : selectCarOne(); break;
				case 4 : editCarOne(); break;
				case 5 : deleteCarOne(); break;
				case 0 : System.out.println("종료합니다."); return;
			}	
		}
	}
	
//	추가
	public void insertCarOne() {
		System.out.println("*** 추가 ***");
		System.out.println("모델명, 가격, 출시일을 입력하세요.");
		System.out.println("다만, 출시일은 반드시 OOOO-OO-OO 형식으로 입력해주세요.");
		System.out.print("모델명 : ");
		String modelName = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		
		System.out.print("출시일 정보를 입력하시겠습니까?(Y/N)");
//		보통 한글자는 Flag라고 표현함. + char받는 Scanner가 없으므로 charAt을 붙인다.
//		char dateFlag = sc.nextLine().charAt(0);
		String dateFlag = sc.nextLine().toUpperCase();
//		보통 고정 값을 앞에다가 쓴다. null이 될 수 있는 변수의 메소드를 부르려고 하면 nullpointerexception 이 발생할 수 있다.
		String date = null;
		if("Y".equals(dateFlag)) {
			System.out.print("출시일 : ");
			date = sc.nextLine();
//			int result = controller.insertCarOne(modelName, price, date);
		}
		int result = controller.insertCarOne(modelName, price, date);
		dmlResultPrint(result, "추가");
//		int result = controller.insertCarOne(modelName, price);
		
	}
	
//	목록 조회
	public void selectCarAll() {
		System.out.println("*** 목록 조회 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
	}
//	주석 강사님 수업||주석 강사님 수업||주석 강사님 수업||
//	단일 조회
	public void selectCarOne() {
		System.out.println("*** 단일 조회 ***");
		System.out.println("검색 기준으로 삼고 싶은 항목을 선택하세요.");
		System.out.println("1. 번호 / 2. 모델명 / 3. 가격 / 4. 출시일 / 0. 조회 취소");
		System.out.print("선택 : ");
		
//		List<Car> list = new ArrayList<Car>(); 결과가 담기는 리스트
//		Object obj = new object();
		
		int choice = sc.nextInt();
//		obj = sc.nextInt();
		sc.nextLine();
		switch(choice) {
			case 1 : selectCarOneByNo(); break;
			case 2 : selectCarOneByName(); break;
			case 3 : selectCarOneByPrice(); break;
			case 4 : selectCarOneByDate(); break;
			case 0 : System.out.println("단일 조회를 취소합니다."); break;
			default : System.out.println("잘못된 번호입니다."); break;
		}
//		list = controller.searchCarList(option, obj); 이런 느낌으로 쓸 수 있다.
	}
//	주석 강사님 수업||주석 강사님 수업||주석 강사님 수업||	

//	단일 조회 -> 번호
	public void selectCarOneByNo() {
		System.out.println("번호를 입력해주세요.");
		System.out.print("번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		Car selectCar = controller.selectCarOneByNo(no);
		selectCarOnePrint(selectCar, "번호");
	}
//	단일 조회 -> 모델명
	public void selectCarOneByName() {
		System.out.println("모델명을 입력해주세요.");
		System.out.print("모델명 : ");
		String name = sc.nextLine();
		Car selectCar = controller.selectCarOneByName(name);
//		if(selectCar != null) {
//			System.out.println(selectCar);
//		} else {
//			System.out.println("조회된 자동차가 없습니다.");
//		}
		selectCarOnePrint(selectCar, "모델명");
	}
//	단일 조회 -> 가격
	public void selectCarOneByPrice() {
		System.out.println("가격을 입력해주세요.");
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		Car selectCar = controller.selectCarOneByPrice(price);
		selectCarOnePrint(selectCar, "가격");
	}
//	단일 조회 -> 출시일
	public void selectCarOneByDate() {
		System.out.println("출시일을 입력해주세요.");
		System.out.println("출시일은 반드시 OOOO-OO-OO 형식으로 입력해주세요.");
		System.out.print("출시일 : ");
		String date = sc.nextLine();
		Car selectCar = controller.selectCarOneByDate(date);
		selectCarOnePrint(selectCar, "출시일");
		
	}
	
//	삭제 메소드
	public void deleteCarOne() {
		System.out.println("*** 삭제 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.println("삭제하고자 하는 자동차 번호를 입력하세요.");
		System.out.print("번호 : ");
		int no = sc.nextInt();
		int result = controller.deleteCarOne(no);
		dmlResultPrint(result, "삭제");
	}
//	수정 메소드
	public void editCarOne() {
		System.out.println("*** 수정 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.println("어떤 모델의 ");
		System.out.print("번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		Object newName = editCarOneCheck("모델명");
		Object newPrice = editCarOneCheck("가격");
		Object newDate = editCarOneCheck("출시일");
		
		int result = controller.editCarOne(no, newName, newPrice, newDate);
		
		dmlResultPrint(result, "수정");
	}
//	반복되는 질문 메소
	public Object editCarOneCheck(String newSomething) {
		Object newOne = null;
		System.out.print(newSomething + "을 수정하시겠습니까?");
		String ynName = sc.nextLine().toUpperCase();
		if("Y".equals(ynName) && "출시일".equals(newSomething)) {
			System.out.println("다만, 출시일은 반드시 OOOO-OO-OO 형식으로 입력해주세요.");
			System.out.print(newSomething + " : ");
			newOne = sc.nextLine();
		} else if("Y".equals(ynName)) {
			System.out.print(newSomething + " : ");
			newOne = sc.nextLine();
		}
		return newOne;
	}
	
	
	
	
//	반복되는 조회-출력 메소드
	public void selectCarOnePrint(Car selectCar, String menuName) {
		if(selectCar != null) {
			System.out.println(selectCar);
		} else {
			System.out.println("해당 '" + menuName + "'(으)로 조회된 자동차가 없습니다.");
		}
	}
	
	
	
	
//	반복되는 출력문 메소드로 작성하여 반복작업 줄이기.
//	dml문 사용한 결과 출력문 작성
	public void dmlResultPrint(int result, String menuName) {
		if(result > 0) System.out.println(menuName + "이(가) 정상 수행되었습니다.");
		else System.out.println(menuName + "중 오류가 발생하였습니다.");
	}
//	Car객체 정보가 담긴 List를 출력하는 메소드 / 비어있으면 비어있다고 출력문 나오기.
	public void printList(List<Car> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for(Car c : list) {
				System.out.println(c);
			}
		}
	}
//	
	
}
