package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {

    public static void main(String[] args) {
	String resource = "resource/Mybatis.xml";
	InputStream inputStream;
	try {
	    inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    
	    
	    
	    SqlSession session = sqlSessionFactory.openSession();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
