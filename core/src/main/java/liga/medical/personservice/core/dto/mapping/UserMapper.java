package liga.medical.personservice.core.dto.mapping;

import liga.medical.personservice.core.dto.model.Role;
import liga.medical.personservice.core.dto.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface UserMapper {

    @Select("select * from clinic.users where username = #{username}")
    User findByUsername(@Param("username") String username);

    @Select("select * from clinic.roles where id in (select role_id from clinic.user_role where user_id = #{userId})")
    Set<Role> getUserRoles(@Param("userId") long userId);

    @Insert("insert into clinic.users (username, password) " +
            "values (#{username}, #{password})")
    void addUserInDB(User user);

    @Insert("insert into clinic.user_role (user_id, role_id) " +
            "values (#{userId}, #{roleId})")
    void assigningRoleToUSer(@Param("userId") long userId, @Param("roleId") long roleId);

}
