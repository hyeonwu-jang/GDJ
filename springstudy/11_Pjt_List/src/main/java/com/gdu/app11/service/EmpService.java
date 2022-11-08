package com.gdu.app11.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;

public interface EmpService {

	public void findAllEmployees(HttpServletRequest request, Model model);
	
	
}
