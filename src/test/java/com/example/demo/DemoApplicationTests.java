package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
class DemoApplicationTests {

    @Test
    void contextLoads() throws ClassNotFoundException, SQLException {
        String sql = "SELECT *  FROM recharge_order";

        //1.加载驱动程序adada
        Class.forName("org.opensearch.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection("jdbc:opensearch://10.189.64.61:9200");
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs);
        }
    }

}
