package com.gdu.app13.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app13.domain.RetireUserDTO;
import com.gdu.app13.domain.SleepUserDTO;
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
	
	// 
	public int updateSessionInfo(UserDTO user);
	
	public int updateUserPassword(UserDTO user);
	
	// 휴면계정 처리
	public int insertSleepUser();
	public int deleteUserForSleep();
	
	// 휴면계정 조회 - 인터셉터
	public SleepUserDTO selectSleepUserById(String id);
	
	// 휴면계정 취소 처리
	public int insertRestoreUser(String id);
	public int deleteSleepUser(String id);
	
	
}
