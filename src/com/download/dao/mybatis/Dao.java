package com.download.dao.mybatis;

import java.util.List;

public interface Dao {

    /**
     * 执行查询返回List
     * 
     * @param sqlId sqlId
     * @param clazz 返回类型
     * @return
     */
    public <T> List<T> executeSqlQuery(String sqlId, T t);
    
    /**
     * 执行更新sql
     * 
     * @param sqlId sqlId
     * @param t 传入参数类
     * @return
     */
    public <T> int executeUpdate(String sqlId, T t);
    
    /**
     * 执行插入sql
     * 
     * @param sqlId sqlId
     * @param t 传入参数类
     * @return
     */
    public <T> int executeInsert(String sqlId, T t);
    
    /**
     * 执行删除sql
     * 
     * @param sqlId sqlId
     * @param t 传入参数类
     * @return
     */
    public <T> int executeDelete(String sqlId, T t);
}
