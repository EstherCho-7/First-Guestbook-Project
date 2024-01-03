package com.oopsw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/controller")
public class FrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		String url="login.html";
		
		//ó�� (ActionFactory)
		Action a=null;
		switch (cmd) {
		case "loginAction": //�α���
			a=new LoginAction();
			break;
		case "logoutAction": //�α׾ƿ�
			a=new LogoutAction();
			break;
		case "signupUIAction": //ȸ�����Թ�ư->ȸ������â
			a=new SignupUIAction();
			break;
		case "signupAction": //ȸ������â->ȸ�����ԿϷ�
			a=new SignupAction();
			break;
		case "getPostAction"://
			a=new getPostAction();
			break;
		case "addPostUIAction": //���ۼ�������
			a=new addPostUIAction();
			break;
		case "addPostAction": //�۵��
			a=new addPostAction();
			break;
		case "viewPostAction":
			a=new viewPostAction();
			break;
		case "updatePostUIAction":
			a=new updatePostUIAction();
			break;
		case "updatePostAction":
			a=new updatePostAction();
			break;
		case "deletePostAction":
			a=new deletePostAction();
			break;
		case "viewTeamsUIAction":
			a=new viewTeamsUIAction();
			break;
		case "idCheckAction":
			a=new idCheckAction();
			break;
		case "nicknameCheckAction":
			a=new NicknameCheckAction();
			break;
			
		default:
			break;
		}
		url=a.execute(request);
		request.getRequestDispatcher("/"+url).forward(request, response);
	}

}
