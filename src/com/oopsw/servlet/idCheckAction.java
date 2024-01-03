package com.oopsw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.oopsw.model.BoardDAO;

public class idCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String memberID=request.getParameter("id");

		boolean idCheck=new BoardDAO().idCheck(memberID);
		if(idCheck==true){
			request.setAttribute("message", "�ߺ� ���̵��Դϴ�.");	
		}
		else {

			request.setAttribute("message", "��� ������ ���̵��Դϴ�.");	
		}
		return "signup_check.jsp";
	}

}