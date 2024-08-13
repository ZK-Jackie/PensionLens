package edu.gdou.pensionlens.service.impl;

import edu.gdou.pensionlens.constant.CalcConstants;
import edu.gdou.pensionlens.mapper.PlanMapper;
import edu.gdou.pensionlens.pojo.*;
import edu.gdou.pensionlens.service.CalcService;
import edu.gdou.pensionlens.service.ScreenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CalcServiceImpl implements CalcService {
    @Resource
    private PlanMapper planMapper;

    @Resource
    private ScreenService screenService;

    @Override
    @Transactional
    public Screen calculate(Screen calcScreen) {
        // 1. 大屏 -> plan表格
        Plan plan = new Plan();
        // 整理成 plan 表格样式后先去取一个 plan id
        planManager(plan, calcScreen);
        planMapper.addPlan(plan);
        planIndexAgeManager(plan, calcScreen);
        planIndexUrbanManager(plan, calcScreen);
        planIndexYearManager(plan, calcScreen);
        // 2. plan -> 数据库
        planMapper.addPlanAge(plan.getPlanAge());
        planMapper.addPlanUrban(plan.getPlanUrban());
        planMapper.addPlanYear(plan.getPlanYear());
        // 3. gPRC 让 python 去算
        /* TODO 算数 */
        // 4. 同时更新大屏信息
        screenService.updateScreenInfo(calcScreen);
        return screenService.getScreenInfo(2);
    }

    private void planManager(Plan plan, Screen screen) {
        Integer personType = null, birthMode = null;
        plan.setPlanDescription("test");
        plan.setPlanPriority(1);
        plan.setPlanArea(44);
        plan.setExecuteStatus(CalcConstants.EXECUTE_STATUS_NO);
        plan.setPlanName("test");
        plan.setStartYear(2020);
        plan.setEndYear(2030);
        plan.setExecuteTime(LocalDateTime.now());
        plan.setPlanVersion("test");
        plan.setLastYearSumSurplus(BigDecimal.valueOf(6500000));
        plan.setRetirePersonTypes(
            List.of(
                CalcConstants.RETIRE_PERSON_TYPE_M,
                CalcConstants.RETIRE_PERSON_TYPE_F,
                CalcConstants.RETIRE_PERSON_TYPE_FC
            )
        );
        plan.setBirthMode(CalcConstants.BIRTH_MODE_MID);
        plan.setInsertUserId(1);
    }

    private void planIndexAgeManager(Plan plan, Screen screen) {
        List<PlanAge> planAges = new ArrayList<>();
        for (Detail detail : screen.getScreenDetails()) {
            if (detail.getDetailName().equals("就业率")) {
                List<Integer> keys = null;
                List<Double> maleValues = null, femaleValues = null;
                for (DetailData detailData : detail.getDetailData()) {
                    keys = (List<Integer>) detailData.getData().get(0);
                    if (detailData.getDataName().get(0).equals("男性就业率")) {
                        maleValues = (List<Double>) detailData.getData().get(1);
                    } else if (detailData.getDataName().get(0).equals("女性就业率")) {
                        femaleValues = (List<Double>) detailData.getData().get(1);
                    }
                }
                if (keys == null || femaleValues == null || maleValues == null) {
                    throw new RuntimeException("数据格式错误");
                }
                for (int i = 0; i < keys.size(); i++) {
                    PlanAge planAge = new PlanAge();
                    planAge.setPlanId(plan.getId());
                    planAge.setAge(keys.get(i));
                    planAge.setFEmploymentRate(maleValues.get(i));
                    planAge.setMEmploymentRate(femaleValues.get(i));
                    planAge.setInsertUserId(plan.getInsertUserId());
                    planAges.add(planAge);
                }
                break;
            }
        }
        plan.setPlanAge(planAges);
    }

    private void planIndexUrbanManager(Plan plan, Screen screen) {
        List<PlanUrban> planUrbans = new ArrayList<>();
        for (Detail detail : screen.getScreenDetails()) {
            if (detail.getDetailName().equals("城镇化率")) {
                for (DetailData detailData : detail.getDetailData()) {
                    Integer nowDataYear = Integer.parseInt(detailData.getDataName().get(0));
                    List<Integer> keys = (List<Integer>) detailData.getData().get(0);
                    List<Double> doubles = (List<Double>) detailData.getData().get(1);
                    List<BigDecimal> values = doubles.stream()
                            .map(BigDecimal::valueOf)
                            .collect(Collectors.toList());
                    for (int i = 0; i < keys.size(); i++) {
                        PlanUrban planUrban = new PlanUrban();
                        planUrban.setPlanId(plan.getId());
                        planUrban.setYear(nowDataYear);
                        planUrban.setAge(keys.get(i));
                        planUrban.setUrbanRate(values.get(i));
                        planUrban.setInsertUserId(plan.getInsertUserId());
                        planUrbans.add(planUrban);
                    }
                }
                break;
            }
        }
        plan.setPlanUrban(planUrbans);
    }

    private void planIndexYearManager(Plan plan, Screen screen) {
        List<PlanYear> planYears = new ArrayList<>();
        List<Integer> keys = null;
        keys = (List<Integer>) screen.getScreenDetails().get(0).getDetailData().get(0).getData().get(0);
        for (int i = 0; i < keys.size(); i++) {
            PlanYear planYear = new PlanYear();
            planYear.setPlanId(plan.getId());
            planYear.setYear(keys.get(i));
            planYear.setInsertUserId(plan.getInsertUserId());
            planYears.add(planYear);
        }
        for (Detail detail : screen.getScreenDetails()) {
            if (detail.getDetailName().equals("退休年龄")) {
                for (DetailData detailData : detail.getDetailData()) {
                    if (detailData.getDataName().get(0).equals("男职工")) {
                        List<Integer> maleRetireAges = (List<Integer>) detailData.getData().get(1);
                        for (int i = 0; i < keys.size(); i++) {
                            planYears.get(i).setMRetire(maleRetireAges.get(i));
                        }
                    } else if (detailData.getDataName().get(0).equals("女职工")) {
                        List<Integer> femaleRetireAges = (List<Integer>) detailData.getData().get(1);
                        for (int i = 0; i < keys.size(); i++) {
                            planYears.get(i).setFRetire(femaleRetireAges.get(i));
                        }
                    } else if (detailData.getDataName().get(0).equals("女干部")) {
                        List<Integer> fcRetireAges = (List<Integer>) detailData.getData().get(1);
                        for (int i = 0; i < keys.size(); i++) {
                            planYears.get(i).setFcRetire(fcRetireAges.get(i));
                        }
                    }
                }
            } else if (detail.getDetailName().equals("参保率")) {
                List<Double> insuranceRates = (List<Double>) detail.getDetailData().get(0).getData().get(1);
                for (int i = 0; i < keys.size(); i++) {
                    planYears.get(i).setInsuranceRate(insuranceRates.get(i));
                }
            } else if (detail.getDetailName().equals("个人缴费率")) {
                List<Double> individualRates = (List<Double>) detail.getDetailData().get(0).getData().get(1);
                for (int i = 0; i < keys.size(); i++) {
                    planYears.get(i).setIndividualRate(individualRates.get(i));
                }
            } else if (detail.getDetailName().equals("企业缴费率")) {
                List<Double> enterpriseRates = (List<Double>) detail.getDetailData().get(0).getData().get(1);
                for (int i = 0; i < keys.size(); i++) {
                    planYears.get(i).setEnterpriseRate(enterpriseRates.get(i));
                }
            } else if (detail.getDetailName().equals("收缴率")) {
                List<Double> collectRates = (List<Double>) detail.getDetailData().get(0).getData().get(1);
                for (int i = 0; i < keys.size(); i++) {
                    planYears.get(i).setCollectRate(collectRates.get(i));
                }
            } else if (detail.getDetailName().equals("在岗平均工资")) {
                List<Double> avgSalaries = (List<Double>) detail.getDetailData().get(0).getData().get(1);
                for (int i = 0; i < keys.size(); i++) {
                    planYears.get(i).setAvgSalary(avgSalaries.get(i));
                }
            } else if (detail.getDetailName().equals("个帐记账利率")) {
                List<Double> accountRates = (List<Double>) detail.getDetailData().get(0).getData().get(1);
                for (int i = 0; i < keys.size(); i++) {
                    planYears.get(i).setAccountRate(accountRates.get(i));
                }
            } else if (detail.getDetailName().equals("过渡系数")) {
                List<Double> transitionRates = (List<Double>) detail.getDetailData().get(0).getData().get(1);
                for (int i = 0; i < keys.size(); i++) {
                    planYears.get(i).setTransition(transitionRates.get(i));
                }
            } else if (detail.getDetailName().equals("增长率")) {
                List<Double> growths = (List<Double>) detail.getDetailData().get(0).getData().get(1);
                for (int i = 0; i < keys.size(); i++) {
                    planYears.get(i).setGrowth(growths.get(i));
                }
            }
        }
        plan.setPlanYear(planYears);
    }
}
