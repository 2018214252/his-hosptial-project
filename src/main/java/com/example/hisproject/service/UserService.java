package com.example.hisproject.service;

import com.example.hisproject.common.EncryptComponent;
import com.example.hisproject.entity.User;
import com.example.hisproject.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder encoder;

    public void insertUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userMapper.insert(user);
    }

    public void deleteUser(Long id){
        userMapper.deleteById(id);
    }

    public User getUserByName(String userName){
        return userMapper.getUserByName(userName);
    }

    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

}
