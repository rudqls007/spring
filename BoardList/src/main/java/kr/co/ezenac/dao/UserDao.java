package kr.co.ezenac.dao;

import kr.co.ezenac.domain.User;

public interface UserDao {

	User selectUser(String id);
	void daleteAll() throws Exception;
	int insertUser(User user);
	int updateUser(User user);
}
