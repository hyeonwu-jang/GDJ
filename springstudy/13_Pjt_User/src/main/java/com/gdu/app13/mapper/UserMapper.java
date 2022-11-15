package com.gdu.app13.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app13.domain.RetireUserDTO;
import com.gdu.app13.domain.UserDTO;

@Mapper
public interface UserMapper {
	
	public UserDTO selectUserByMap(Map<String, Object> map);
	
	public RetireUserDTO selectRetireUserById(String id);
	
	public int insertUser(UserDTO user);
	
	public int updateAccessLog(String id);
	public int insertAccessLog(String id);
	
	// 회원탈퇴 (user 테이블 탈퇴, retire 테이블 추가)
	public int deleteUser(int userNo);
	public int insertRetireUser(RetireUserDTO retireUser);
	
	
	
	
}
