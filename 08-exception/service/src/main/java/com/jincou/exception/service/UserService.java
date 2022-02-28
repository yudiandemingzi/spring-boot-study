package com.jincou.exception.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jincou.exception.constant.enums.BusinessResponseEnum;
import com.jincou.exception.dao.UserMapper;
import com.jincou.exception.dto.UserDTO;
import com.jincou.exception.entity.User;

import com.jincou.exception.pojo.CommandResult;
import com.jincou.exception.util.ClientUtil;
import com.jincou.exception.util.EntityUtil;
import org.springframework.stereotype.Service;

/**
 *  用户实现类
 *
 * @author xub
 * @date 2022/2/28 上午11:24
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {


   /**
    * 查询用户信息
    */
    public CommandResult<UserDTO> queryDetail(Integer userId) {
        final User user = this.getById(userId);
        // 校验非空
        BusinessResponseEnum.USER_NOT_FOUND.assertNotNull(user);
        return CommandResult.ofSucceed(EntityUtil.changeEntity( UserDTO.class,user));
    }


    /**
     * 这里在提供一个 优化代码的地方 跟异常无关。正常我们走dubbo也好Feign也好，拿到的对象都是上面这样的,正常我们要先解析状态，然后取值
     */
    public CommandResult<UserDTO> queryUserInfo(Integer userId) {
         //假设这里是通过第三方接口获取的数据
         CommandResult<UserDTO> commandResult = this.queryDetail(userId);
         //如果失败，那么直接抛异常了
         if(!commandResult.isSuccess()){
           return CommandResult.ofFail(commandResult.getCode(), commandResult.getMessage());
           //也可以抛出异常 这里是需要new BaseException 因为这里模拟的是调的是第三方接口，所以我们无法指定错误枚举
            //throw new BaseException(commandResult.getCode(), commandResult.getMessage());
         }
         //如果成功，才会获取数据,做一些其它逻辑处理
        final UserDTO userDTO = commandResult.getResult();


         //那么其实上面是可以优化的，我们可以抽出一个公共方法来。这样只需一步就可以了。
        UserDTO dto = ClientUtil.execute(() -> this.queryDetail(userId));
        return CommandResult.ofSucceed(dto);
    }
}
