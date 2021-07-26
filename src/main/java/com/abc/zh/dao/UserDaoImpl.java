package com.abc.zh.dao;

import com.abc.zh.entity.User;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8";
    public static final String username = "root";
    public static final String password = "12345678";

    @Override
    public List<User> queryUserList() throws ClassNotFoundException, SQLException {

        ArrayList<User> users = new ArrayList<>();

        Class.forName(driver);

        /**
         * 问题一：频繁获取/释放s数据库连接，影响数据库和应用性能
         * 解决：数据库连接池技术，C3P0,DRUID（阿里巴巴 出品）
         */
        Connection connection = DriverManager.getConnection(url, username, password);

        /**
         * 问题二：SQL语句硬编码，后期难以维护
         * 解决方案：sql语句和代码分离，将sql 写在xml配置文件中
         */
        String sql = "select * from user";

        /**
         * 问题三：sql语句where条件和占位符一一对应，后期难以维护
         */
        String sqlByCondition = "select * from where name = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        /**
         * 结果集解析麻烦，查询列硬编码
         * 期望：单条记录直接放一个对象中，多条记录返回实体集合
         */
        while (resultSet.next()) {
            User user = new User();

            users.add(user);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return users;
    }
}
