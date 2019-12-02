package io.inke.athena.support.service;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.support.model.AppmetaModel;

import java.util.List;

public interface AppmetaService extends BaseService<AppmetaModel> {

    ResponseCommon<List<AppmetaModel>> getAllByUserId(Long userId);

}
