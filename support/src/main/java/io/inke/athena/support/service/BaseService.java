package io.inke.athena.support.service;

import io.inke.athena.common.response.ResponseCommon;

public interface BaseService<T> {

    ResponseCommon<T> addObject(T object);

}
