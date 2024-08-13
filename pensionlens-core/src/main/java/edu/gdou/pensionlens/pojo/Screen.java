package edu.gdou.pensionlens.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screen {
    private Integer screenId;
    private String screenName;
    private Boolean isPredict;
    private Boolean isActive;
    private List<Plan> screenPlan;
    private List<Detail> screenDetails;
}
