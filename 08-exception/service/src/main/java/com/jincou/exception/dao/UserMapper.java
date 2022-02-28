package com.jincou.exception.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jincou.exception.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xub
 * @since 2022-02-25
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
