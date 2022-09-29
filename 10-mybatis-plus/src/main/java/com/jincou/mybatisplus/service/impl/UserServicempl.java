package com.jincou.mybatisplus.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jincou.mybatisplus.dao.UserMapper;
import com.jincou.mybatisplus.model.UserDO;
import com.jincou.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 *  用户实现类
 * 
 * @author xub
 * @date 2022/9/26 上午11:26
 */
@Service
public class UserServicempl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}
