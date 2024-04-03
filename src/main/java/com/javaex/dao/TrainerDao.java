package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.TrainerVo;

@Repository
public class TrainerDao {

	@Autowired
	private SqlSession sqlSession;

	// 로그인
	public TrainerVo trainerSelectByIdPw(TrainerVo trainerVo) {
		System.out.println("TrainerDao.memberSelectByIdPw()");
		TrainerVo authUser = sqlSession.selectOne("trainer.selectByIdPw", trainerVo);
		return authUser;
	}

	// 회원가입
	public int join(TrainerVo trainerVo) {
		System.out.println("TrainerDao.join()");
		int count = sqlSession.insert("trainer.join", trainerVo);
		return count;
	}

	// 트레이너 사진 등록
	public int addPhoto(TrainerVo trainerVo) {
		System.out.println("TrainerDao.addPhoto()");
		int count = sqlSession.update("trainer.addPhoto", trainerVo);
		return count;
	}

	// id 중복체크
	public int check(String id) {
		System.out.println("TrainerDao.userModify()");
		int count = sqlSession.selectOne("trainer.idCheck", id);
		System.out.println(count);
		return count;
	}

	// 조회no(회원정보수정 폼)
	public TrainerVo trainerSelectOneByNo(int no) {
		System.out.println("TrainerDao.userSelectOneByNo()");

		TrainerVo trainerVo = sqlSession.selectOne("trainer.selectOneByNo", no);
		return trainerVo;
	}

	// 회원 정보 수정
	public int trainerUpdate(TrainerVo trainerVo) {
		System.out.println("TrainerDao.userModify()");
		int count = sqlSession.update("trainer.update", trainerVo);
		System.out.println(count);
		return count;
	}
	
	//트레이너 이름, 사진 저장 이름, 전체회원수, 관리 회원 수
	public TrainerVo selectTrainerInfo(int no) {
		System.out.println("TrainerDao.selectTrainerInfo()");

		TrainerVo trainerVo = sqlSession.selectOne("trainer.selectTrainerInfo", no);
		return trainerVo;
	}

}