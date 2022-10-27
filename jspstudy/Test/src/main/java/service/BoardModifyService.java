package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardModifyService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		int result = 0;
		Optional<String> strNo = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(strNo.orElse("0"));
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = formatter.format(date);
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		board.setCreateDate(createDate);
		
		result = BoardDao.getInstance().updateBoard(board);
		
		return new ActionForward("board/updateResult.jsp?res=" + result, true);
	}

}
