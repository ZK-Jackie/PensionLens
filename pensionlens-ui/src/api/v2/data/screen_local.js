// 当前用户可访问的大屏信息
// 0-全国大屏，1-政策大屏，2-区域大屏，3-配置大屏
export const screenIds = {
  screenId: 2,
  screenName: '全国大屏',
  isPredict: false,
  isActive: true,
  screenPlan: [{
    screenId: 2,
    planId: null,
    priority: null,
  }],
  screenDetails: [
    {
      screenId: 2,
      detailId: 0,
      detailSpot: 0,
      detailName: '不同生育模式下不同年龄的人数预测情况',
      isMultiOption: true,
      detailData: [
        {
          dataId: 0,
          dataName: ['男', '高生育模式'],
          displayableMode: ["bar", "line", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 55000000,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: false,
          isInfo: false,
          data: [
            [2022, 2023, 2024, 2025, 2026, 2027, 2028],
            [57872605, 58085464, 58260040, 58438437, 58578040, 5868012, 5848785]
          ],
        },
        {
          dataId: 1,
          dataName: ['男', '中生育模式'],
          displayableMode: ["bar", "line", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 50000000,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: false,
          isInfo: false,
          data: [
            [2022, 2023, 2024, 2025, 2026, 2027, 2028],
            [57639312, 57781721, 57889605, 57967987, 58013017, 58025958, 58009197]
          ],
        },
        {
          dataId: 2,
          dataName: ['男', '低生育模式'],
          displayableMode: ["bar", "line", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 50000000,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: false,
          isInfo: false,
          data: [
            [2022, 2023, 2024, 2025, 2026, 2027, 2028],
            [57372691, 57434589, 57466250, 57437325, 57380883, 57297759, 57189759]
          ],
        },
        {
          dataId: 3,
          dataName: ['女', '高生育模式'],
          displayableMode: ["bar", "line", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 50000000,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: false,
          isInfo: false,
          data: [
            [2022, 2023, 2024, 2025, 2026, 2027, 2028],
            [53033651, 53252598, 533444014, 53642842, 53813850, 53958366, 54078360]
          ],
        },
        {
          dataId: 4,
          dataName: ['女', '中生育模式'],
          displayableMode: ["bar", "line", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 55000000,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: false,
          isInfo: false,
          data: [
            [2022, 2023, 2024, 2025, 2026, 2027, 2028],
            [52843979, 53005102, 53141509, 53257409, 53349628, 53419188, 534676638]
          ],
        },
        {
          dataId: 5,
          dataName: ['女', '低生育模式'],
          displayableMode: ["bar", "line", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 50000000,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023, 2024, 2025, 2026, 2027, 2028],
            [57372691, 57434589, 57466250, 57437325, 57380883, 57297759, 57189759]
          ]
        }
      ]
    },
    {
      screenId: 2,
      detailId: 1,
      detailSpot: 1,
      detailName: '广东省城镇养老保险未来收入和支出',
      isMultiOption: true,
      detailData: [

      ]
    }
  ]
}