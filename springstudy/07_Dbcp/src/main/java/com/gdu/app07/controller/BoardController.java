package com.gdu.app07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.service.BoardService;

import lombok.AllArgsConstructor;

@Controller

// 필드를 이용한 생성자를 만들어 두면,
// 생성자의 매개변수로 컨테이너의 Bean이 자동 주입(@Autowired)되므로
// 필드에 @Autowired 처리할 필요가 없다.
@AllArgsConstructor

public class BoardController {
	
	// @Autowired가 없음에 주의!
	private BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("brd/list")
	public String list(Model model) {  // Model은 forward할 속성(Attribute)을 저장할 때 사용한다. // 속성에 저장해서 값을 보냄
		model.addAttribute("boards", boardService.findAllBoards());
		return "board/list";  // board폴더의 list.jsp로 forward
	}
	
	@GetMapping("brd/write")
	public String write() {
		return "board/write";  // board폴더의 write.jsp로 forward
	}
	
	@PostMapping("brd/add")
	public String add(BoardDTO board) {
		boardService.saveBoard(board);  // saveBoard()로 부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";    // 추가, 수정, 삭제는 리다이렉트!!
	}
	
	@GetMapping("brd/detail")
	public String detail(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no
			           , Model model) {  
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/detail";  // board폴더의 detail.jsp로 forward
	}
	
	@PostMapping("brd/edit")	//	(수정하기 전값 출력하기)
	public String edit(int board_no
			         , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/edit";  // board폴더의 edit.jsp로 forward 
	}
	
	@PostMapping("brd/modify")
	public String modify(BoardDTO board) {
		boardService.modifyBoard(board);  // modifyBoard()로 부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/detail?board_no=" + board.getBoard_no();
	}
	
	@PostMapping("brd/remove")
	public String remove(int board_no) {
		boardService.removeBoard(board_no);  // removeBoard()로 부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";
	}
	
}
