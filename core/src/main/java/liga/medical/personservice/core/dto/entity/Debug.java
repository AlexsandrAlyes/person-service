package liga.medical.personservice.core.dto.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Data
@Entity
@Table(name = "debug", schema = "db_log")
public class Debug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "system_type_id")
    private String systemTypeId;

    @Column(name = "method_params", length = 1000)
    private String methodParams;

}