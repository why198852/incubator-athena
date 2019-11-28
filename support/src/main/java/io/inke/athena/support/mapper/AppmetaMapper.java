package io.inke.athena.support.mapper;

import io.inke.athena.support.model.AppmetaModel;
import io.inke.athena.support.provider.AppmetaProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AppmetaMapper extends BaseMapper<AppmetaModel> {

    @InsertProvider(type = AppmetaProvider.class, method = "addModel")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer insertModel(AppmetaModel object);

    @Results(id = "appmetaRequiredResults", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name")
    })
    @Select(value = "SELECT id, name FROM appmeta WHERE name = #{name}")
    AppmetaModel findByName(CharSequence name);

}
