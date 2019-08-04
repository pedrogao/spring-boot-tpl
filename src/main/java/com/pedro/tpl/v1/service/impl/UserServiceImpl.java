package com.pedro.tpl.v1.service.impl;

import com.pedro.tpl.v1.model.User;
import com.pedro.tpl.v1.mapper.UserMapper;
import com.pedro.tpl.v1.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pedro
 * @since 2019-08-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
