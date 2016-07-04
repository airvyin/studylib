package com.download.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.download.entity.Book;
import com.download.entity.Chapter;
import com.download.entity.Page;
import com.download.entity.Impl.BookFromHanhan;

public class BaseDao implements Dao {
    
    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory != null) {
            return sqlSessionFactory;
        }
        String resource = "com/download/dao/mybatis/config/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Override
    public <T> List<T> executeSqlQuery(String sqlId, T t) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<T> bookList = sqlSession.selectList(sqlId, t);
        sqlSession.close();
        return bookList;
    }
    @Override
    public <T> int executeUpdate(String sqlId, T t) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int updateCount = sqlSession.update(sqlId, t);
        sqlSession.commit();
        sqlSession.close();
        return updateCount;
    }

    @Override
    public <T> int executeInsert(String sqlId, T t) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int insertCount = sqlSession.insert(sqlId, t);
        sqlSession.commit();
        sqlSession.close();
        return insertCount;
    }

    @Override
    public <T> int executeDelete(String sqlId, T t) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int deleteCount = sqlSession.delete(sqlId, t);
        sqlSession.commit();
        sqlSession.close();
        return deleteCount;
    }
}
