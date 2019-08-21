package com.pnu.bbs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pnu.bbs.dto.BBSDto;

@Repository
public class BBSDaoImpl implements BBSDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	final String nameSpace="com.pnu.bbs.dao.BBSDao";

	@Override
	public List<BBSDto> list(String dong) {
//		return sqlSession.selectList(nameSpace+".list");
		return sqlSession.selectList(nameSpace+".selectDong", dong);  
		                                        // ㄴ내가 만들 메소드
	}

	public List<Map<String, Object>> selectMemberList(){
		return sqlSession.selectList(nameSpace+".selectMemberList");
	}
	// 리스트를 받으면 자동으로 하나의 레코드를 BBSDTO에 넣는다 
	// 조건) DTO와 테이블의 변수명이같으면
	

	@Override
	public void write(BBSDto article){
		sqlSession.insert(nameSpace +".write", article);
	}
	
	@Override
	public BBSDto content(int articleNum) {
		return sqlSession.selectOne(nameSpace+".content", articleNum);
		// sqlSession 중 하나를 받아온다. ~밑에 있는 아이디 값이 content인 친구를,,, 넘어가는 파라미터는 articleNum
	}

	@Override
	public void upHit(int articleNum) {
		sqlSession.update(nameSpace+".upHit",articleNum);
	}


}

//  --> mapper.bbs로
// 컨트롤러 -> 서비스 -> dao
// controller -> service -> dao  -> mapper


