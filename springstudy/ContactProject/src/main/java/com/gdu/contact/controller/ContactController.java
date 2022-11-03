package com.gdu.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.contact.domain.ContactDTO;
import com.gdu.contact.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("contacts", contactService.findAllContacts());
		return "contact/contact01";
	}

	@GetMapping("add")
	public String add() {
		return "contact/contact02";
	}

	@PostMapping("write")
	public String write(ContactDTO contact) {
		int result = contactService.addContacts(contact);
		
		// 모델로 전달하기? -- 뷰까지 가지 않도록 막아야함.
		// 여기서 처리하기?  -- 여기서 처리하거나, request, response를 이용하여 impl에서 처리
		
		/*
		 * try { if(result > 0) { PrintWriter out = response.getWriter();
		 * out.println("<script>"); out.println("alert('연락처가 등록되었습니다.);");
		 * out.println("location.href='${contextPath}/contact/contact03.jsp'");
		 * out.println("</script>"); }
		 * 
		 * } catch(Exception e) { e.printStackTrace(); }
		 * 
		 */
		System.out.println("삽입결과 : " + result);
		System.out.println(contact.getNo());
		return "redirect:/view?no=" + contact.getNo();
	}
	
	@GetMapping("view")
	public String view(@RequestParam(value="no", required=false, defaultValue="0") int no, Model model) {
		model.addAttribute("contact", contactService.findContact(no));
		
		return "contact/contact03";
	}

}
