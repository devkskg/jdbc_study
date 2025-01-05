package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	public int insertMember(String memberId, String memberPw, String memberName, String memberEmail, String memberPhone, String memberGender) {
		Member m = new Member(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
		int result = new MemberDao().insertMember(m); // 마지막교시 11
//		if(result > 0) {
////			성공
////			System.out.println("회원 추가 완료");
//		} else {
////			실패
////			System.out.println("회원 추가 실패");
//		}
		return result;
	}
	
	public List<Member> selectMemberAll() {
		List<Member> list = new MemberDao().selectMemberAll();
		return list;
	}
	
	
}