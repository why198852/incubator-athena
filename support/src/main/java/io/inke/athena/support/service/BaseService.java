package io.inke.athena.support.service;

import io.inke.athena.common.response.ResponseCommon;

public interface BaseService<T> {

    ResponseCommon<Integer> addObject(T model);

    /**
     * get model by name
     *
     * @param name source name
     * @return user info model
     */
    ResponseCommon<T> getByName(CharSequence name);

}
