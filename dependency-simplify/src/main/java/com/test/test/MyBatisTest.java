package com.test.test;

import com.test.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author Dooby Kim
 * @Date 2024/1/21 6:52 下午
 * @Version 1.0
 */
public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream(resource));

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取映射接口的动态代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        // 获取 Executor

        // 执行一次查询操作
        System.out.println(bookMapper.selectBookById(1));
    }
}
