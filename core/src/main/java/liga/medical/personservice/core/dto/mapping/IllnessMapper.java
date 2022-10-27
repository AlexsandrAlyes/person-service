package liga.medical.personservice.core.dto.mapping;

import liga.medical.personservice.core.dto.model.Illness;
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
public interface IllnessMapper {

    @Results(id = "illness", value = {
            @Result(property = "typeId", column = "type_id"),
            @Result(property = "appearanceDttm", column = "appearance_dttm"),
            @Result(property = "recoveryDt", column = "recovery_dt"),
            @Result(property = "medicalCardId", column = "medical_card_id")
    })

    @Select("Select * from clinic.illness; ")
    List<Illness> listIllness();

    @Select("select * from clinic.illness where id = #{id};")
    @ResultMap("illness")
    Illness getIllnessById(@Param("id") long id);

    @Insert("insert into clinic.illness (" +
            "type_id,heaviness,appearance_dttm,recovery_dt,medical_card_id) values(" +
            "#{typeId},#{heaviness},#{appearanceDttm},#{recoveryDt},#{medicalCardId});")
    void addIllnessInDB(Illness illness);

    @Delete("delete from clinic.illness where id = #{id};")
    void deleteIllnessById(@Param("id") long id);
}
