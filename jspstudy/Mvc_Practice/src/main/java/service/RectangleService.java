package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class RectangleService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));

		request.setAttribute("shape", "rectangle");
		request.setAttribute("width", a);
		request.setAttribute("height", b);
		request.setAttribute("area", a*b);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/output.jsp");
		actionForward.setRedirect(false); // 포워드하겠다!
		
		// ActionForward 반환
		return actionForward;
	}

}
