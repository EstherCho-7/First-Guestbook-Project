package com.oopsw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.oopsw.model.BoardDAO;

public class NicknameCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
String memberNickname=request.getParameter("memberNickname");
		
		boolean nicknameCheck=new BoardDAO().nicknameCheck(memberNickname);
		if(nicknameCheck==true){
			request.setAttribute("message", "�ߺ� �г��� �Դϴ�.");
		}
		else{
			request.setAttribute("message", "��� ������ �г��� �Դϴ�.");
		}
		
		return "signup_check.jsp";
	}

}