package io.inke.athena.core.controller;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.core.param.UserParam;
import io.inke.athena.support.model.UserModel;
import io.inke.athena.support.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "register")
    public ResponseCommon<UserModel> register(@RequestBody UserParam param) {
        UserModel user = new UserModel();
        BeanUtils.copyProperties(param, user);
        return this.userService.addObject(user);
    }

}
