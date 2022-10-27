package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BoardAddService;
import service.BoardDetailService;
import service.BoardListService;
import service.BoardModifyService;
import service.BoardService;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 / 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 요청 확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());	// 
		
		// BoardService 객체 생성(
		BoardService service = null;
		
		// ActionForward 객체
		ActionForward af = null;
		
		// 요청에 따른 메소드 선택 및 실행
		switch(urlMapping) {
		case "/add.do":
			af = new ActionForward("board/add.jsp", false);
			break;
		case "/list.do":
			service = new BoardListService();
			break;
		case "/insert.do":
			service = new BoardAddService();
			break;
		case "/detail.do":
			service = new BoardDetailService();
			break;
		case "/modify.do":
			service = new BoardModifyService();
			break;
		}
		
		
		
		// service 실행
		if(service != null) {
			af = service.execute(request, response);
		}
		
		// 어디로 어떻게?
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getView());
			} else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
