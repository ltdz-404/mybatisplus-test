package com.thz.ssmmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thz.ssmmybatisplus.entity.User;
import com.thz.ssmmybatisplus.mapper.UserMapper;
import com.thz.ssmmybatisplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
