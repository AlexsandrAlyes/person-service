package liga.medical.personservice.core.dto.mapping;

import liga.medical.personservice.core.dto.model.PersonData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface PersonDataMapper {

    @Results(id = "person_data", value = {
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "birthDate", column = "birth_date"),
            @Result(property = "contactId", column = "contact_id"),
            @Result(property = "medicalCardId", column = "medical_card_id"),
            @Result(property = "parentId", column = "parent_id")
    })

    @Select("Select * from clinic.person_data")
    List<PersonData> listPersonData();

    @Select("select * from clinic.person_data where id = #{id};")
    @ResultMap("person_data")
    PersonData getPersonDateById(@Param("id") long id);

    @Insert("insert into clinic.person_data (" +
            "first_name,last_name,birth_date,age,sex,contact_id,medical_card_id,parent_id) values(" +
            "#{firstName},#{lastName},#{birthDate},#{age},#{sex},#{contactId},#{medicalCardId},#{parentId});")
    void addPersonDateInDB(PersonData personData);

    @Delete("delete from clinic.person_data where id = #{id};")
    void deletePersonDateById(@Param("id") long id);

}
