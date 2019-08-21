package com.pnu.bbs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.pnu.bbs.dao.BBSDao;
import com.pnu.bbs.dto.BBSDto;
import com.pnu.bbs.service.BBSService;

@Controller
public class BBSController {
	@Autowired // 스프링이 지원하는 애노테이션, 타입으로 빈을 찾음
	private BBSService bbsService;
	private BBSDao mDAO;

	@RequestMapping("/list.bbs")
	public String list(Model model, BBSDto article, @RequestParam(value = "dong", required = false, defaultValue ="장전2동") String dong) {
		model.addAttribute("articleList", bbsService.list(dong));
		return "list";
	}
	
	@RequestMapping("/search.bbs")
	public String search() {
		return "search";
	}
	@RequestMapping("/ajax.bbs")
	public String ajax() {
		return "ajax";
	}
	@RequestMapping("/ajaxdata.bbs")
	public String ajaxdata() {
		return "ajaxdata";
	}
	
	@RequestMapping("/mlist.bbs")
	public String mlist() {
		return "mlist";
	}

	// 글쓰기 작성 버튼
	@PostMapping(value = "/write.bbs")
	public String write(BBSDto article, @RequestPart("fname") List<MultipartFile> fileList) {
		article.setId("ID");
		System.out.println(article.getContent());
		bbsService.write(article);
		return "redirect:/list.bbs"; // 다시 그전 게시판으로로 돌아감
	}

	@RequestMapping(value = "/content.bbs")
	// @RequestParam : 요청한놈이 가져온 파라미터 값 ,,, 이름이 같으면 생략가능
	public String content(@RequestParam int articleNum, Model model) {
		model.addAttribute("article", bbsService.content(articleNum));
		// model.addAttribute("pageNum", pageNum);
		return "content";
	}

	// -> service로

}
