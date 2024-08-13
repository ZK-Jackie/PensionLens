package edu.gdou.pensionlens.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanAge {
    private Integer id;
    private Integer planId;
    private Integer age;
    private Double mEmploymentRate;
    private Double fEmploymentRate;
    private Integer insertUserId;
}
