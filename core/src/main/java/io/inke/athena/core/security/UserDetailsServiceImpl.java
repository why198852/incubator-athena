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
        String[] userNameAndId = userName.split(String.valueOf(Character.LINE_SEPARATOR));
        log.debug("validate user <{}> from database", userNameAndId[0]);
        ResponseCommon<UserModel> response = this.userService.getByName(userNameAndId[0]);
        if (!ObjectUtils.isEmpty(response.getDetail())) {
            return new User(String.join(String.valueOf(Character.LINE_SEPARATOR), response.getDetail().getUserName(), String.valueOf(response.getDetail().getId())),
                    response.getDetail().getPassword(),
                    Collections.emptyList());
        }
        log.debug("user <{}> not found from database", userNameAndId[0]);
        throw new UsernameNotFoundException(String.format("this user %s not found", userNameAndId[0]));
    }
}
