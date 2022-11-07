package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeDetailService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	FreeDAO dao = FreeDAO.getInstance();
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		long freeNo = Long.parseLong(opt.orElse("0"));
		
		Free free = dao.selectFree(freeNo);
		request.setAttribute("free", free);
		
		return new ActionForward("BoardProject/detail.jsp", false);
	}

}
