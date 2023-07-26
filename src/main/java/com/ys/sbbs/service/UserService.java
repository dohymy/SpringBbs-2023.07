package com.ys.sbbs.service;

import java.util.List;

import com.ys.sbbs.entity.User;

public interface UserService {
	// new - interface
	// maven bbs에서 uDao가 사용된 것들 객체 생성
	
		public static final int CORRECT_LOGIN = 0;
		public static final int WRONG_PASSWORD = 1;
		public static final int UID_NOT_EXIST = 2;
		
		// interface는 public등을 안써도됨
		int getUserCount();

		User getUser(String uid);
		
		List<User> getUserList(int page);
		
		void insertUser(User user);
		
		void updateUser(User user);
		
		void deleteUser(String uid);
		
		int login(String uid, String pwd);
		
}
