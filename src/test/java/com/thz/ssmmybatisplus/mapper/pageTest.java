package com.thz.ssmmybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thz.ssmmybatisplus.entity.User;
import com.thz.ssmmybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class pageTest {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Test
    public void testMapper1(){
        IPage<User> page=new Page<>(2,3);
        IPage<User> result = userMapper.selectPage(page,null);
        for (User record : result.getRecords()) {
            System.out.println(record);
        }
    }
    @Test
    public void testServiceMapper(){
        IPage<User> page = new Page<>(2, 3);
        IPage<User> result= userService.page(page);
        result.getRecords().forEach(System.out::println);
    }
    @Test
    public void testCustomMapper(){
        IPage<User> page = new Page<>(2, 3);
        IPage<User> result = userMapper.selectUserPage(page);
        result.getRecords().forEach(System.out::println);
    }

}
