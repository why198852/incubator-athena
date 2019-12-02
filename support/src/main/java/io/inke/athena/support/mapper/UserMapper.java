package io.inke.athena.support.mapper;

import io.inke.athena.support.model.UserModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper extends BaseMapper<UserModel> {

    @Insert("INSERT INTO user (username, password) VALUES (#{user.userName}, #{user.password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "user.id")
    @Override
    Integer insertModel(@Param(value = "user") UserModel object);

    /**
     * find user model by user name
     *
     * @param userName user name
     * @return user model
     */
    @ResultMap(value = "userRequiredResults")
    @Select(value = "SELECT id, username, password FROM user WHERE username = #{userName}")
    UserModel findByUserName(@Param(value = "userName") String userName);

    @Results(id = "userRequiredResults", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "userName", column = "username"),
            @Result(property = "password", column = "password")
    })
    @Select(value = "SELECT id, username, password FROM user WHERE username = #{userName} AND password = #{password}")
    UserModel findByUserNameAndPassword(@Param(value = "userName") String userName, @Param(value = "password") String password);

    @Results(id = "userRequiredResultsNotPassword", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "userName", column = "username")
    })
    @Select(value = "SELECT id, username FROM user WHERE id = #{id}")
    UserModel findById(Long id);

}
