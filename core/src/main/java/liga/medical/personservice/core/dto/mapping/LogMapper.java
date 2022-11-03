package liga.medical.personservice.core.dto.mapping;

import liga.medical.personservice.core.dto.model.LogDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

@Mapper
public interface LogMapper {

    @Results(id = "logs", value = {
            @Result(property = "logDateTime", column = "log_date_time")
    })

    @Insert("INSERT INTO clinic.logs(log_date_time, level_info, logger, message, username) VALUES (#{logDateTime}, #{level}, #{logger}, #{message}, #{username});")
    void addLogsInDB(LogDTO logDTO);
}
