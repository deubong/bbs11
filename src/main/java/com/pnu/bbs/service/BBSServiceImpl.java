package com.pnu.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pnu.bbs.dao.BBSDao;
import com.pnu.bbs.dto.BBSDto;



@Service
public class BBSServiceImpl implements BBSService {
	@Autowired
	private BBSDao bbsDao;

//	@Autowired는 타입으로 찾지만 String이 여러개 있더라도 servlet-context에 이름을 같게  적었다면 알아서 찾아짐 (최신 4.0~)
//	@Resource는 빈의 이름으로 찾음
//	@Resource(name= "saveDir")
	@Autowired
	private String saveDir;

	@Override
	public List<BBSDto> list(String dong)  {
		//System.out.println(saveDir);
		return bbsDao.list(dong);		
	}
	@Override
	public void write(BBSDto article){
		bbsDao.write(article);
	}
		
	// 쿼리문이 두개이상 들어가므로 Transation으로!
	// AOP가 트랜잭션 시작(전화기) -> 정상적으로 작동하면 커밋,,,, 실패하면 롤백
	@Transactional          
	@Override
	public BBSDto content(int articleNum) {
		bbsDao.upHit(articleNum); // 읽을때 조회수 1 증가 하고
		BBSDto article = bbsDao.content(articleNum); // 그담에 출력
		return article;
	}
	// 트랜잭션 처리는 서비스단에서 처리한다.

	
}
//  -> DAO로

