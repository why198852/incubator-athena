package io.inke.athena.support.mapper;

import io.inke.athena.support.model.AppmetaModel;
import io.inke.athena.support.provider.AppmetaProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppmetaMapper extends BaseMapper<AppmetaModel> {

    @InsertProvider(type = AppmetaProvider.class, method = "addModel")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer insertModel(AppmetaModel object);

    @Results(id = "appmetaRequiredResultsManyToOne", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "active", column = "active"),
            @Result(property = "token", column = "token"),
            @Result(property = "displayName", column = "displayName"),
            @Result(property = "deadTime", column = "deadTime"),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "modifyTime", column = "modifyTime"),
            @Result(property = "deleted", column = "deleted"),
            @Result(property = "locked", column = "locked"),
            @Result(property = "user", column = "userId", one = @One(
                    select = "io.inke.athena.support.mapper.UserMapper.findById"
            ))
    })
    @Select(value = "SELECT id, name, code, active, token, displayName, deadTime, createTime, modifyTime, deleted, locked, userId FROM appmeta WHERE name = #{name}")
    AppmetaModel findByName(CharSequence name);

    @Results(id = "appmetaRequiredResults", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "active", column = "active"),
            @Result(property = "token", column = "token"),
            @Result(property = "displayName", column = "displayName"),
            @Result(property = "deadTime", column = "deadTime"),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "modifyTime", column = "modifyTime"),
            @Result(property = "deleted", column = "deleted"),
            @Result(property = "locked", column = "locked")
    })
    @Select(value = "SELECT id, name, code, active, token, displayName, deadTime, createTime, modifyTime, deleted, locked FROM appmeta WHERE id = #{id}")
    AppmetaModel findById(Long id);

    @ResultMap(value = "appmetaRequiredResults")
    @Select(value = "SELECT id, name, code, active, token, displayName, deadTime, createTime, modifyTime, deleted, locked FROM appmeta WHERE userId = #{userId}")
    List<AppmetaModel> findAllByUserId(Long userId);

}
