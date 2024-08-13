package edu.gdou.pensionlens.mapper;

import edu.gdou.pensionlens.pojo.Plan;
import edu.gdou.pensionlens.pojo.PlanAge;
import edu.gdou.pensionlens.pojo.PlanUrban;
import edu.gdou.pensionlens.pojo.PlanYear;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanMapper {

    void addPlan(Plan plan);

    void addPlanAge(List<PlanAge> planAge);

    void addPlanUrban(List<PlanUrban> planUrban);

    void addPlanYear(List<PlanYear> planYear);

}
