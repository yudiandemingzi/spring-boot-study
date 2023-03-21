package com.jincou.mybatisplus.dao;

import com.jincou.mybatisplus.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author <a>xub</a>
 * @since 2022-09-26
 */
@Mapper
public interface UserMapper extends MyBaseMapper<UserDO> {

}
