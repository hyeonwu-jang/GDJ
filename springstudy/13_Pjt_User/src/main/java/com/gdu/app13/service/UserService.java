package com.gdu.app13.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app13.domain.SleepUserDTO;
import com.gdu.app13.domain.UserDTO;

public interface UserService {

	public Map<String, Object> isReduceId(String id);
	public Map<String, Object> isReduceEmail(String email);
	public Map<String, Object> sendAuthCode(String email);
	
	public void join(HttpServletRequest request, HttpServletResponse response);
	
	public void retire(HttpServletRequest request, HttpServletResponse response);

	public void login(HttpServletRequest request, HttpServletResponse response);
	public void logout(HttpServletRequest request, HttpServletResponse response);
	
	public void keepLogin(HttpServletRequest request, HttpServletResponse response);
	
	// keepLoginInterceptor에서 호출
	public UserDTO getUserBySessionId(Map<String, Object> map);        								
	
	public Map<String, Object> confirmPassword(HttpServletRequest request);
	
	public void modifyPassword(HttpServletRequest request, HttpServletResponse response);
	
	// SleepUserScheduler에서 호출
	public void sleepUserHandle(); 
	
	public SleepUserDTO getSleepUserById(String id);
	
	public void restoreUser(HttpServletRequest request, HttpServletResponse response);
	
	// 네이버아이디로그인
	public String getNaverLoginApiURL(HttpServletRequest request);  // 1
	public UserDTO getNaverLoginTokenNProfile(HttpServletRequest request);  // 2
	
	
	
	
}
