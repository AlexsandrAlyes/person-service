package liga.medical.personservice.core.dto.mapping;

import liga.medical.personservice.core.dto.model.Contact;
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
public interface ContactMapper {

    @Results(id = "contact", value = {
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "profileLink", column = "profile_link")
    })

    @Select("Select * from clinic.contact; ")
    List<Contact> listContacts();

    @Select("select * from clinic.contact where id = #{id};")
    @ResultMap("contact")
    Contact getContactById(@Param("id") long id);

    @Insert("insert into clinic.contact (phone_number,email,profile_link) values(#{phoneNumber},#{email},#{profileLink});")
    void addContactInDB(Contact contact);

    @Delete("delete from clinic.contact where id = #{id};")
    void deleteContactById(@Param("id") long id);
}
