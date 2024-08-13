package edu.gdou.pensionlens.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"dataQuerySql"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailData {
    private Integer dataId;
    private List<String> dataName;
    private String dataQuerySql;
    private List<String> displayMode;
    private List<String> displayableMode;
    private Integer startTime;
    private Integer endTime;
    private String keyLabel;
    private String keyUnit;
    private String valueLabel;
    private String valueUnit;
    private String numPrecision;
    private BigDecimal maxValue;
    private BigDecimal minValue;
    private DataColor dataColor;
    private Boolean isPredict;
    private Boolean isInfo;
    private Boolean isDefault;
    private List<Object> data;
    private List<Object> predictData;
}
