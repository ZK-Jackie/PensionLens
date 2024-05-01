package edu.gdou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail {
    private String detailId;
    private String dataId;
    private Short displayMode;
    private Integer startYear;
    private Integer endYear;
    private Integer predictStartYear;
    private Integer predictEndYear;
    private String lastUpdateUserId;
    private LocalDateTime lastUpdateTime;
    private Chart chartOption;
}
