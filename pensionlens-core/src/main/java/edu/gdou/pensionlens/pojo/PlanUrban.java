package edu.gdou.pensionlens.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanUrban {
    private Integer id;
    private Integer planId;
    private Integer year;
    private Integer age;
    private BigDecimal urbanRate;
    private Integer insertUserId;
}
