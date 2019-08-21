package com.pnu.bbs.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.pnu.bbs.dto.BBSDto;

public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BBSServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gu= request.getParameter("gu");
		String dong = request.getParameter("dong");
		String result = request.getParameter("result1");
		System.out.println("구 : "+gu+"  동 :  "+dong);
		request.setAttribute("dong", dong);
		request.setAttribute("result1", result);
		RequestDispatcher dispatch = request.getRequestDispatcher("/list.bbs");
		dispatch.forward(request, response);
	} 
	
}
