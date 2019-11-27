package io.inke.athena.support.mapper;

import io.inke.athena.support.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper extends BaseMapper<UserModel> {

    @Insert("INSERT INTO user (id, username, password) VALUES (#{id}, #{userName}, #{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Override
    UserModel insertModel(UserModel object);

}
