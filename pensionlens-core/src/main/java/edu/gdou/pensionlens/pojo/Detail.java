package edu.gdou.pensionlens.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail {
    private Integer screenId;
    private Integer detailId;
    private Short detailSpot;
    private String displayMode;
    private Short minDataUnit;
    private String detailName;
    private Boolean isMultiOption;
    private List<DetailData> detailData;
}
