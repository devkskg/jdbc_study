package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

//	View로부터 전달받은 데이터 가공 -> Service 전달
public class Controller {
	private Service service = new Service();
	
	public int insertCarOne(String modelName, int price, String date) {
//		System.out.println("=========컨트롤러 테스트========");
//		System.out.println("모델명 : " + modelName);
//		System.out.println("가격 : " + price);
//		System.out.println("출시일 : " + date);
//		System.out.println("=========컨트롤러 테스트========");
		Car car = new Car(modelName, price, date);
		int result = service.insertCarOne(car);
		return result;
	}
//	오버로딩을 하려 했으나 컨트롤러에서 메소드가 하나 늘어나면 뒤에 나오는 service, dao 등에도 계속 메소드를 추가 작성 해야 하므로 안 좋다.
//	public int insertCarOne(String modelName, int price) {
//		return
//	}
	
	public List<Car> selectCarAll(){
		return service.selectCarAll();
	}
//	주석 강사님 수업||주석 강사님 수업||주석 강사님 수업||
//	public List<Car> searchCarList(int option, Object obj){
//		return 
//	}
//	주석 강사님 수업||주석 강사님 수업||주석 강사님 수업||
	public Car selectCarOneByNo(int no) {
		return service.selectCarOneByNo(no);
	}
	public Car selectCarOneByName(String name) {
		return service.selectCarOneByName(name);
	}
	public Car selectCarOneByPrice(int price) {
		return service.selectCarOneByPrice(price);
	}

	public Car selectCarOneByDate(String date) {
		return service.selectCarOneByDate(date);
	}
}
