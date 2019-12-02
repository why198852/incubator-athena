package io.inke.athena.core.controller;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.core.param.AppmetaParam;
import io.inke.athena.core.security.jwt.JwtTokenTemplate;
import io.inke.athena.support.model.AppmetaModel;
import io.inke.athena.support.model.UserModel;
import io.inke.athena.support.service.AppmetaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "appmeta")
public class AppmetaController {

    @Autowired
    private AppmetaService appmetaService;

    @PostMapping(value = "create")
    ResponseCommon<Integer> create(@Valid @RequestBody AppmetaParam param) {
        AppmetaModel model = new AppmetaModel();
        BeanUtils.copyProperties(param, model);
        UserModel user = new UserModel();
        user.setId(Integer.valueOf(param.getUserId()));
        model.setUser(user);
        return this.appmetaService.addObject(model);
    }

    @GetMapping(value = "list")
    ResponseCommon<List<AppmetaModel>> list(Authentication authentication) {
        return this.appmetaService.getAllByUserId(JwtTokenTemplate.getUserId(authentication).longValue());
    }

}
