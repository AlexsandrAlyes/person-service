package liga.medical.personservice.core.dto.mapping;

import liga.medical.personservice.core.dto.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface RoleMapper {

    @Select("select * from clinic.roles")
    Set<Role> getAllRoles();

    @Select("select * from clinic.roles where name = #{name}")
    Role getRoleByNameFromDB(@Param("name")String name);
}
