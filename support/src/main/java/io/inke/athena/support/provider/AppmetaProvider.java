package io.inke.athena.support.provider;

import io.inke.athena.support.model.AppmetaModel;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.ObjectUtils;

public class AppmetaProvider {

    private String tableName = "appmeta";

    public String addModel(AppmetaModel model) {
        return new SQL() {{
            INSERT_INTO(tableName);
            if (!ObjectUtils.isEmpty(model.getName())) {
                VALUES(String.join(".", tableName, "name"), "#{name}");
            }
            if (!ObjectUtils.isEmpty(model.getCode())) {
                VALUES(String.join(".", tableName, "code"), "#{code}");
            }
            if (!ObjectUtils.isEmpty(model.getActive())) {
                VALUES(String.join(".", tableName, "active"), "#{active}");
            }
            if (!ObjectUtils.isEmpty(model.getToken())) {
                VALUES(String.join(".", tableName, "token"), "#{token}");
            }
            if (!ObjectUtils.isEmpty(model.getDisplayName())) {
                VALUES(String.join(".", tableName, "displayName"), "#{displayName}");
            }
            if (!ObjectUtils.isEmpty(model.getDeadTime())) {
                VALUES(String.join(".", tableName, "deadTime"), "#{deadTime}");
            }
            if (!ObjectUtils.isEmpty(model.getCreateTime())) {
                VALUES(String.join(".", tableName, "createTime"), "#{createTime}");
            }
            if (!ObjectUtils.isEmpty(model.getModifyTime())) {
                VALUES(String.join(".", tableName, "modifyTime"), "#{modifyTime}");
            }
            if (!ObjectUtils.isEmpty(model.getDeleted())) {
                VALUES(String.join(".", tableName, "deleted"), "#{deleted}");
            }
            if (!ObjectUtils.isEmpty(model.getLocked())) {
                VALUES(String.join(".", tableName, "locked"), "#{locked}");
            }
        }}.toString();
    }

}
