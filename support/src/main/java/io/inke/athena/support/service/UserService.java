package io.inke.athena.support.service;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.support.model.UserModel;

public interface UserService extends BaseService<UserModel> {

    /**
     * get user model by user name
     *
     * @param userName source user name
     * @return user model
     */
    ResponseCommon<UserModel> getByUserName(String userName);

}
