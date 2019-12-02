package io.inke.athena.support.service;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.common.utils.TokenUtils;
import io.inke.athena.support.mapper.AppmetaMapper;
import io.inke.athena.support.model.AppmetaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppmetaServiceImpl implements AppmetaService {

    @Autowired
    private AppmetaMapper appmetaMapper;

    @Override
    public ResponseCommon<Integer> addObject(AppmetaModel model) {
        model.setToken(TokenUtils.generateValue(model.getName()));
        if (this.appmetaMapper.insertModel(model) > 0) {
            return ResponseCommon.success(model.getId());
        } else {
            return ResponseCommon.success(0);
        }
    }

    @Override
    public ResponseCommon<AppmetaModel> getByName(CharSequence name) {
        return ResponseCommon.success(this.appmetaMapper.findByName(name));
    }

    @Override
    public ResponseCommon<AppmetaModel> getById(Long id) {
        return ResponseCommon.success(this.appmetaMapper.findById(id));
    }

    @Override
    public ResponseCommon<List<AppmetaModel>> getAllByUserId(Long userId) {
        return ResponseCommon.success(this.appmetaMapper.findAllByUserId(userId));
    }

}
