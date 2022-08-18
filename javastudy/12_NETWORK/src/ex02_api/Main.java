package ex02_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	// 요청
	// 1. Request
	// 2. 클라이언트 -> 서버

	// 파라미터
	// 1. Parameter
	// 2. 보내는 데이터(변수 개념)

	// 응답
	// 1. Response
	// 2. 서버 -> 클라이언트
	
	public static void m1() {
		
		// 전국종량제봉투가격표준데이터
		
		// API 주소 (주소 + 요청 파라미터)
		
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		try {
			
			String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("인천광역시", "UTF-8");
			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("계양구", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("생활쓰레기", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8");
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 주소 접속 실패");
		}
		
		// 입력 스트림(응답) 생성
		// 1. 응답 성공 시 정상 스트림, 실패 시 에러 스트림
		// 2. 응답 데이터는 StringBuilder에 저장
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			// 스트림 종료
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// File 생성
		File file = new File("C:\\storage", "api1.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// xml 분석
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();	// <response> (최상위 태그)
			System.out.println(root.getNodeName());
			
			NodeList nodeList = root.getChildNodes();	// <response>의 자식 태그(<header>, <body>)
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);			// <header>와 <body>
				System.out.println("  " + node.getNodeName());
				
				NodeList nodeList2 = node.getChildNodes();	// <header>의 자식 태그(<resultCode>), (<resultMsg>), <body>의 자식 태그(<items>, <numOfRows>, <pageNo>, <totalCount>)
				for(int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					System.out.println("   " + node2.getNodeName());
					if(node2.getNodeName().equals("items")) { // <items> 태그 대상
						
						NodeList items = node2.getChildNodes();
						for(int k = 0; k < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("      " + item.getNodeName());
							
							NodeList itemChildren = item.getChildNodes();	// <item>의 자식 태그
							for(int l = 0; l < itemChildren.getLength(); l++) {
								Node itemChild = itemChildren.item(l);
								System.out.println("        " + itemChild.getNodeName() + ":" + itemChild.getTextContent());
							}
							
						}
					}
				}
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 접속 종료
		con.disconnect();
	}
	
	public static void m2() {
		
		String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&startCreateDt=20220808");										// 인코딩이 필요없는 데이터 - 영문, 숫자
			urlBuilder.append("&endCreateDt=20220812");
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = urlBuilder.toString();
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			br.close();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		String response = sb.toString();
		
		File file = new File("c:\\storage", "api2.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void m3() {
			
			// xml 파싱
			
			File file = new File("C:\\storage", "api2.xml");
			
			try {
				
				// api2.xml 문서 -> doc 객체
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(file);
				
				
				// api2.xml 문서의 최상위 태그 -> root
				Element root = doc.getDocumentElement();
				
				// <item>...</item> 태그 하나 == 특정 날짜의 데이터
				NodeList items = root.getElementsByTagName("item");  // 태그 이름으로 찾기
			
				StringBuilder sb = new StringBuilder();
				
				for(int i = 0; i < items.getLength(); i++) {
					Node item = items.item(i);						// [item: null] x 5
					NodeList itemChildren = item.getChildNodes();
					
					
					for(int j = 0; j < itemChildren.getLength(); j++) {
						Node itemChild = itemChildren.item(j);
						
						if(itemChild.getNodeName().equals("stateDt")) {
							sb.append(" 날짜 : ").append(itemChild.getTextContent());
						}
						
						else if(itemChild.getNodeName().equals("decideCnt")) {
							sb.append(" 확진자 : ").append(itemChild.getTextContent());
						}

						else if(itemChild.getNodeName().equals("deathCnt")) {
							sb.append(" 사망자 : ").append(itemChild.getTextContent());
						}
					}
					sb.append("\n");
					
				
					
					
					// Node stateDt 			== <stateDt>20220812</stateDt>
					// stateDt.getNodeName() 	== stateDt (태그이름)
					// stateDt.getTextContent() == 20220812 (태그내부텍스트)
					
					
				}
				
				System.out.println(sb.toString());
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	
	public static void m4() {
		
		StringBuilder urlBuilder = new StringBuilder();
		String serviceKey = "tuKJQnWosgochz4Xdrz/EnE0fod1HOfyo0ZK7gAZMn7bUHdBQNpbTN6zksDAGe2KOWYJLpKMYuvDJWjBI5aAvQ==";
		
		try {
			
			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&base_date=20220818");
			urlBuilder.append("&base_time=1100");
			urlBuilder.append("&nx=55");
			urlBuilder.append("&ny=127");
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = urlBuilder.toString();
		
		// 서버와 접속 = URL, 
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// Reader 준비 = Reader, StringBuilder, con code, 
		
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		String response = sb.toString();
		
		// Writer 준비 = File, Writer
		
		File file = new File("c:\\storage", "api3.xml");
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m6() {
		
		File file = new File("c:\\storage", "api3.xml");
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item");
			for(int i = 0; i < items.getLength(); i++) {
				// Node item = items.item(i);
				Element item = (Element)items.item(i);	// Node -> Element 타입으로 다운캐스팅
				Node category = item.getElementsByTagName("category").item(0);
				Node obsrValue = item.getElementsByTagName("obsrValue").item(0);
				String strCategory = null;
				switch(category.getTextContent()) {
				case "PTY" : strCategory = "강수형태"; break;
				case "REH" : strCategory = "습도"; break;
				case "RN1" : strCategory = "강수량(1시간)"; break;
				case "T!H" : strCategory = "기온"; break;
				case "UUU" : strCategory = "동서바람성분"; break;
				case "VEC" : strCategory = "풍향"; break;
				case "VVV" : strCategory = "남북바람성분"; break;
				case "WSD" : strCategory = "풍속"; break;
				
				}
				
				System.out.println(strCategory + " : " + obsrValue.getTextContent());
				
				
				
				
			}
			
			
		} catch(Exception e) {
			
			
		}
		
	}
	
	public static void m7() {
		
		String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";
		
		URL url = null;
		HttpURLConnection con = null;
			
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		File file = new File("c:\\storage", "api4.xml");
		BufferedWriter bw = null;
		
		try {
			
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(sb.toString());
			bw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			StringBuilder sb = new StringBuilder();
			
			NodeList data = root.getElementsByTagName("data");
			
			data.
			
			Node title = );
		
					
					

			NodeList title = root.getElementsByTagName("title");
			NodeList pubData = root.getElementsByTagName("pubData");
			NodeList hour = root.getElementsByTagName("hour");
			NodeList temp = root.getElementsByTagName("temp");
			NodeList wfKor = root.getElementsByTagName("wfKor");
			
			
			
			System.out.println();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	public static void m9() {
		
		try {
			
			// 접속
			String apiURL = "https://www.kma.go.kr/XML/weather/sfc_web_map.xml";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// 접속 확인
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("API 접속 실패");
				return;
			}
			
			// 바이트 입력 스트림 -> 문자 입력 스트림 -> 버퍼 추가
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			File file = new File("C:\\storage", "sfc_web_map.xml");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			// readLine() 메소드를 이용한 복사
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line + "\n");
			}
			
			// 닫기
			bw.close();
			br.close();
			con.disconnect();
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println("API 서버 오류");
		}
		
	}
	
	public static void m10() {
		
		// <local stn_id="90" icon="03" desc="구름많음" ta="25.7">속초</local>
		// 태그이름 : local, 속성 : stn_id ~ , 텍스트 : 속초
		
		File file = new File("c:\\storage", "sfc_web_map.xml");
		
		try {
			
			StringBuilder sb = new StringBuilder();
	
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement(); // <current xmlns="current"> 태그
			
			
			Element weather = (Element)root.getElementsByTagName("weather").item(0); // <weather year="2022" month="08" day="18" hour="15">
			sb.append(weather.getAttribute("year") + "년 ");
			sb.append(weather.getAttribute("month") + "월 ");
			sb.append(weather.getAttribute("day") + "일 ");
			sb.append(weather.getAttribute("hour") + "시\n");

			NodeList locals = root.getElementsByTagName("local");
			for(int i = 0; i < locals.getLength(); i++) {
				Element local = (Element)locals.item(i);
				sb.append(local.getTextContent() + " : ");
				sb.append(local.getAttribute("ta") + "℃ ");
				sb.append(local.getAttribute("desc") + "\n");
				
			}
			
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	public static void main(String[] args) {

//		m1();
//		m2();
		m3();
//		m4();
//		m6();
//		m7();
//		m9();
//		m10();
		
	}

}
