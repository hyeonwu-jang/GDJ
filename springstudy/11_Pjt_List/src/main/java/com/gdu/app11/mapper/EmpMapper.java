package com.gdu.app11.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app11.domain.EmpDTO;

@Mapper
public interface EmpMapper {
	
	// findAllEmployees에서 사용할 매핑값(DB)
	public int selectAllEmployeesCount();
	public List<EmpDTO> selectEmployeesByPage(Map<String, Object> map);
	
	// findEmployees에서 사용할 매핑값(DB)
	public int selectFindEmployeesCount(Map<String, Object> map);
	public List<EmpDTO> selectFindEmployees(Map<String, Object> map);
	
	// 
	public List<EmpDTO> selectAutoCompleteList(String param);
}
