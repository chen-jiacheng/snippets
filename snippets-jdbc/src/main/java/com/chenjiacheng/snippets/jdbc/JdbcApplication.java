package com.chenjiacheng.snippets.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * Created by chenjiacheng on 2024/3/26 23:36
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class JdbcApplication {

    public static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("jdbc.properties"));
            // 加载MySQL驱动程序
            Class.forName(properties.getProperty("jdbc.driver"));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
            );

            // 执行SQL查询
            String query = "SELECT * FROM USER";
            List<Map<String, Object>> results = query(connection, query);
            if (!results.isEmpty()) {
                for (Map<String, Object> result : results) {
                    System.out.println("------------------------------------");
                    for (Map.Entry<String, Object> entry : result.entrySet()) {
                        System.out.println(entry.getValue().getClass().getName()+" "+entry.getKey()+" = "+entry.getValue());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    /***
     * 执行查询SQL
     * @param connect 数据库连接
     * @param sql sql语句
     * @param params sql语句参数
     * @return 数据库结果集
     * @throws SQLException sql相关异常
     */
    public static List<Map<String, Object>> query(Connection connect, String sql, String... params) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connect.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i, params[i]);
                }
            }
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();

            // 处理查询结果
            List<Map<String, Object>> results = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, Object> result = new HashMap<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String key = metaData.getColumnName(i);
                    Object value = resultSet.getObject(key);
                    result.put(key, value);
                }
                results.add(result);
            }
            return results;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

    }

}