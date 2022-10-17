package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class CircleService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		double r = Double.parseDouble(request.getParameter("r"));
		
		request.setAttribute("shape", "circle");
		request.setAttribute("radius", r);
		request.setAttribute("area", Math.PI * Math.pow(r, 2));
		
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/output.jsp");
		actionForward.setRedirect(false); // 포워드하겠다!
		
		// ActionForward 반환
		return actionForward;
		
	}

}
