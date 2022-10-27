package liga.medical.personservice.core.dto.mapping;

import liga.medical.personservice.core.dto.model.MedicalCard;
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
public interface MedicalCardMapper {

    @Results(id = "medical_card", value = {
            @Result(property = "clientStatus", column = "client_status"),
            @Result(property = "medStatus", column = "med_status"),
            @Result(property = "registryDate", column = "registry_date")
    })

    @Select("Select * from clinic.medical_card; ")
    List<MedicalCard> listMedicalCard();

    @Select("select * from clinic.medical_card where id = #{id};")
    @ResultMap("medical_card")
    MedicalCard getMedicalCardById(@Param("id") long id);

    @Insert("insert into clinic.medical_card (" +
            "client_status,med_status,registry_date,comment) values(" +
            "#{clientStatus},#{medStatus},#{registryDate},#{comment});")
    void addMedicalCardInDB(MedicalCard medicalCard);

    @Delete("delete from clinic.medical_card where id = #{id};")
    void deleteMedicalCardById(@Param("id") long id);
}
