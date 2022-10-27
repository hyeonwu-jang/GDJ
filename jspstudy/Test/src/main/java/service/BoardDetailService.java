package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardDetailService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		Optional<String> strNo = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(strNo.orElse("0"));
		
		Board board = BoardDao.getInstance().detailBoard(boardNo);
		
		request.setAttribute("board", board);
		
		return new ActionForward("board/detail.jsp", false);
	}

}
