package com.abc.zh.dao;

import com.abc.zh.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> queryUserList() throws ClassNotFoundException, SQLException;
}
