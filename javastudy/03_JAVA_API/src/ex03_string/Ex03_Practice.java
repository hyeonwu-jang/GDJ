package ex03_string;

public class Ex03_Practice {

	public static void main(String[] args) {
		
		
		// 연습. 파일이름을 파일명과 확장자로 분리
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행한다.
			
		String fullName = "apple.jpg";
		String fileName = ""; // apple
		String extName = ""; // jpg
		
		int index = fullName.lastIndexOf(".");
		
		if(fullName.endsWith("jpg") || fullName.endsWith("jpg") || fullName.endsWith("jpg")) {
			fileName += fullName.substring(0, index);
			extName += fullName.substring(index + 1);	
		}		
		System.out.println(fileName);
		System.out.println(extName);
	
		// 연습. 문자열 "abc12345def67890ghijk"에서 
		// 아라비아 숫자 1234567890을 제외하고 한 글자씩 화면에 출력하시오.
		// 1)	
		String str = "abc12345def67890ghijk";
		for(char ch = 'a'; ch <= 'k'; ch++) {
			if(ch < 10) {
				continue;
			} else {
				System.out.println(ch);
			}
		}
		
		// 2)
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9') {
				continue;
			} 
				System.out.println(ch);
			
		}

	}

}
