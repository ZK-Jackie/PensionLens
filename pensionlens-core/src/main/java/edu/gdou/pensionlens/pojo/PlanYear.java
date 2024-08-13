package edu.gdou.pensionlens.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanYear {
    private Integer id;
    private Integer planId;
    private Integer year;
    private Integer mRetire;
    private Integer fRetire;
    private Integer fcRetire;
    private Double insuranceRate;
    private Double individualRate;
    private Double enterpriseRate;
    private Double collectRate;
    private Double avgSalary;
    private Double accountRate;
    private Double transition;
    private Double growth;
    private Integer insertUserId;
}
