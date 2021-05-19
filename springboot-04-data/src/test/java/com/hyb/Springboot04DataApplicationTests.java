package com.hyb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看一下默认数据源
        System.out.println(dataSource.getClass());
        //默认：class com.zaxxer.hikari.HikariDataSource
        //导入druid-spring-boot-starter打印class com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper
        //导入druid打印class com.alibaba.druid.pool.DruidDataSource

        //获取数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //关闭
        connection.close();
    }

}
