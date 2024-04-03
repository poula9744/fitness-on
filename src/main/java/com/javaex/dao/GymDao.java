package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GeneralVo;
import com.javaex.vo.MemberVo;

@Repository
public class GymDao {

	@Autowired
	private SqlSession sqlSession;

	// 일반회원권 등록
	public int registerMembership(GeneralVo generalVo) {
		System.out.println("GymDao.registerMembership()");
		int result = sqlSession.insert("gym.registerMembership", generalVo);
		return result;
	}

	// 일반회원권 만료일
	public String membershipOver(int no) {
		System.out.println("GymDao.membershipOver()");
		String over = sqlSession.selectOne("gym.membershipOver", no);
		return over;
	}

	// 일반회원 입장
	public int entry(int no) {
		System.out.println("GymDao.entry()");
		System.out.println(no);
		int count = sqlSession.update("gym.entry", no);
		return count;
	}

	// 일반회원 퇴장
	public int leave(int no) {
		System.out.println("GymDao.leave()");
		System.out.println(no);
		int count = sqlSession.update("gym.leave", no);
		return count;
	}

	// 일반회원 운동 시간
	public MemberVo trainingTime(int no) {
		System.out.println("GymDao.leave()");
		System.out.println(no);
		MemberVo trainingTime = sqlSession.selectOne("gym.trainingTime", no);
		System.out.println(trainingTime);
		return trainingTime;
	}
}