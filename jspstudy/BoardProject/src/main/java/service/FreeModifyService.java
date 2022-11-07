package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeModifyService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		FreeDAO dao = FreeDAO.getInstance();
		
		int result = 0;
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		long freeNo = Long.parseLong(opt.orElse("0"));
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		Free free = new Free();
		free.setFreeNo(freeNo);
		free.setTitle(title);
		free.setContent(content);
		free.setIp(ip);

		result = dao.updateFree(free);
		
		request.setAttribute("free", dao.selectAllFree());
		
		if(result > 0) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('게시글이 수정되었습니다.')");
			out.println("location.href='" + request.getContextPath() + "/detail.do?freeNo=" + freeNo +"'");
			out.println("</script>");
		}
		
		
		
		return null;
	}

}
