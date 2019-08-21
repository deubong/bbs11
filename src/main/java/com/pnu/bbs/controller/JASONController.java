package com.pnu.bbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnu.bbs.dao.BBSDao;

@RestController
@RequestMapping("/json")
public class JASONController {
	// 여기는 데이터를 공급해주는 용도

	// 사용할 DAO를 객체를 만듬
	@Autowired
	private BBSDao mDAO;

	// http://127.0.0.1:8090/web/json/mlist?key=123
	@RequestMapping(value = "/mlist", method = RequestMethod.GET, produces = "application/json")
	public Map<String, List<Map<String, Object>>> json(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		// DB에서 오는 값을 JSON문서로 만듬
		List<Map<String, Object>> list = mDAO.selectMemberList();
		Map<String,List<Map<String, Object>>> list2 = new HashMap<String, List<Map<String,Object>>>();
		list2.put("memberList", list);
		return list2; 
	}
}  