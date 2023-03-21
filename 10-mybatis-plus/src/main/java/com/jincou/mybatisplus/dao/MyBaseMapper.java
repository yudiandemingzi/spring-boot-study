package com.jincou.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {
    
    /**
     * 全字段更新，不会忽略null值
     *
     * @param entity 实体对象
     */
    int alwaysUpdateSomeColumnById(@Param("et") T entity);

    /**
     * 全量插入,等价于insert
     * 
     * @param entityList 实体集合
     */
    int insertBatchSomeColumn(List<T> entityList);
    
    /**
     *  查询所有用户
     */
    List<T> findAll();
}
