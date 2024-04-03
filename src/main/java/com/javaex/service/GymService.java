
package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GymDao;
import com.javaex.vo.GeneralVo;
import com.javaex.vo.MemberVo;

@Service
public class GymService {

	@Autowired
	private GymDao gymDao;

	// 일반회원권 등록
	public int exeRegisterMembership(GeneralVo generalVo) {
		System.out.println("GymService.exeRegisterMembership()");
		int result = gymDao.registerMembership(generalVo);
		return result;
	}

	// 일반회원권 만료일
	public String exeMemberOver(int no) {
		System.out.println("GymService.exeMemberOver()");
		String over = gymDao.membershipOver(no);
		return over;
	}

	// 일반회원 입장
	public int exeEntry(int no) {
		System.out.println("GymService.exeEntry()");
		int count = gymDao.entry(no);
		return count;
	}

	// 일반회원 퇴장
	public int exeLeave(int no) {
		System.out.println("GymService.exeLeave()");
		int count = gymDao.leave(no);
		return count;
	}

	// 일반회원 운동시간
	public MemberVo exetrainingTime(int no) {
		System.out.println("GymService.exetrainingTime()");
		MemberVo trainingTime = gymDao.trainingTime(no);
		return trainingTime;
	}
}
