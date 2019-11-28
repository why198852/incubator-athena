package io.inke.athena.core.security;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.support.model.UserModel;
import io.inke.athena.support.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.debug("validate user <{}> from database", userName);
        ResponseCommon<UserModel> response = this.userService.getByUserName(userName);
        if (!ObjectUtils.isEmpty(response.getDetail())) {
            return new User(response.getDetail().getUserName(), response.getDetail().getPassword(), Collections.emptyList());
        }
        log.debug("user <{}> not found from database", userName);
        throw new UsernameNotFoundException(String.format("this user %s not found", userName));
    }
}
