package io.inke.athena.support.service;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.support.model.UserModel;

public interface UserService extends BaseService<UserModel> {

    /**
     * get user model by user name
     *
     * @param userName source user name
     * @return user info model
     */
    ResponseCommon<UserModel> getByUserName(String userName);

    /**
     * get user model by user name and password
     *
     * @param userName source user name
     * @param password source user password
     * @return user info model
     */
    ResponseCommon<UserModel> getByUserNameAndPassword(String userName, String password);

}
