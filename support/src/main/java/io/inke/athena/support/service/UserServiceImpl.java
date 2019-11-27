package io.inke.athena.support.service;

import io.inke.athena.support.mapper.UserMapper;
import io.inke.athena.support.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserModel addObject(UserModel model) {
        return userMapper.insertModel(model);
    }

}
