package com.ys.sbbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ys.sbbs.entity.User;

@Mapper
public interface UserDaoMySQL {
	// userService의 객체에 sql을 써줌
	
	@Select("select count(uid) from users where isDeleted=0")
	int getUserCount();
	// 번거로운 작업 없이 sql을 사용할 수 있음
	
	@Select("select * from users where uid=#{uid}")
	User getUser(String uid);
	// 기존 매핑에 ?로 쓰던 부분이 #{  }의 형태로 바뀜
	
	@Select("select * from users where isDeleted=0 order by regDate desc, "
			+ "uid limit 10 offset #{offset}")
	List<User> getUserList(int offset);
	
	// 기능에 따라 dml이 바뀐다.
	// 객체에는 각 필드 값을 넣어준다.
	@Insert("insert into users values (#{uid}, #{pwd}, #{uname}, #{email}, "
			+ "default, default, #{profile}, #{addr})")
	void insertUser(User user);
	
	@Update("update users set pwd=#{pwd}, uname=#{uname}, email=#{email}, "
			+ "profile=#{profile}, addr=#{addr} where uid=#{uid}")
	void updateUser(User user);
	
	@Update("update users set isDeleted=1 where uid=#{uid}")
	void deleteUser(String uid);
	
}
