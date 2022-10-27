package liga.medical.personservice.core.dto.mapping;

import liga.medical.personservice.core.dto.model.Address;
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
public interface AddressMapper {

    @Results(id = "address", value = {
            @Result(property = "countryId", column = "country_id"),
            @Result(property = "contactId", column = "contact_id")
    })

    @Select("Select * from clinic.address; ")
    List<Address> listAddress();

    @Select("select * from clinic.address where id = #{id};")
    @ResultMap("address")
    Address getAddressById(@Param("id") long id);

    @Insert("insert into clinic.address (" +
            "country_id,city,index,street,building,flat,contact_id) values(" +
            "#{countryId},#{city},#{index},#{street},#{building},#{flat},#{contactId});")
    void addAddressInDB(Address address);

    @Delete("delete from clinic.address where id = #{id};")
    void deleteAddressById(@Param("id") long id);
}

