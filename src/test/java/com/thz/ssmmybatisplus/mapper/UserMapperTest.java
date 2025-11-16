package com.thz.ssmmybatisplus.mapper;

import com.thz.ssmmybatisplus.entity.User;
import com.thz.ssmmybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Test
    public void testlist(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void testSaveOrUpdate(){
        User user1 = userService.getById(2);
        user1.setName("xiaohu");

        User user2 = new User();
        user2.setName("lisi");
        user2.setAge(27);
        user2.setEmail("lisi@email.com");
    }
    @Test
    public void testSaveBatch(){
        User user1 = new User();
        user1.setName("dongdong");
        user1.setAge(49);
        user1.setEmail("dongdong@email.com");

        User user2 = new User();
        user2.setName("nannan");
        user2.setAge(29);
        user2.setEmail("nannan@email.com");
        List<User> users = List.of(user1, user2);
        userService.saveBatch(users);
    }

}