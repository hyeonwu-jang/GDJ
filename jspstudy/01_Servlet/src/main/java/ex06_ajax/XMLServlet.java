package ex06_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;

@WebServlet("/XMLServlet")
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		request.setCharacterEncoding("UTF-8");
		
		// 요청 파라미터
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// 응답할 JSON 객체 만들기
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("age", age);
		
		/*
		 	{name:"장현우", age:"30"}
		 	
		 */
		
		// 응답할 JSON 객체를 XML로 변환하기
		JSONObject person = new JSONObject();
		person.put("person", obj);
		String responseXML = XML.toString(person);
		
		/*
		 	<person>
		 		<name>장현우</name>
		 		<age>30</age>
		 	</person>
		 */
		
		// 응답
		response.setContentType("application/xml; charset=UTF-8");	// XML 데이터의 MIME-TYPE
		
		PrintWriter out = response.getWriter();
		out.println(responseXML);	// 응답 데이터는 XML
		out.close();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
