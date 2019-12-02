package io.inke.athena.support.service;

import io.inke.athena.common.crypto.CryptoCommon;
import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.support.mapper.UserMapper;
import io.inke.athena.support.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public ResponseCommon<Integer> addObject(UserModel model) {
        model.setPassword(CryptoCommon.bcryptEncoder(model.getPassword()));
        if (this.userMapper.insertModel(model) > 0) {
            return ResponseCommon.success(model.getId());
        } else {
            return ResponseCommon.success(0);
        }
    }

    public ResponseCommon<UserModel> getByName(CharSequence source) {
        return ResponseCommon.success(this.userMapper.findByUserName(source.toString()));
    }

    @Override
    public ResponseCommon<UserModel> getById(Long id) {
        return ResponseCommon.success(this.userMapper.findById(id));
    }

    @Override
    public ResponseCommon<UserModel> getByUserNameAndPassword(String userName, String password) {
        return ResponseCommon.success(this.userMapper.findByUserNameAndPassword(userName, password));
    }

}
