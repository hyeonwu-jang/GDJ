package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class FreeRemoveService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		FreeDAO dao = FreeDAO.getInstance();
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		long freeNo = Long.parseLong(opt.orElse("0"));
		
		
		
		int result = dao.deleteFree(freeNo);
		
		if(result > 0) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('게시글이 삭제되었습니다.')");
			out.println("location.href='"+ request.getContextPath() + "/list.do'");
			out.println("</script>");
		}
		
		return null;
	}

}
