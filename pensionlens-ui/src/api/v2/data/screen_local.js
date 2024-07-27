// 当前用户可访问的大屏信息
// 0-全国大屏，1-政策大屏，2-区域大屏，3-配置大屏
export const screenInfo = {
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
      minDataUnit: 1,
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
          isInfo: false,
          data: [
            [2022, 2023],
            [57872605, 58085464]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [58260040, 58438437, 58578040, 58680120, 58487850]
          ]
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
            [2022, 2023],
            [57639312, 57781721]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [57889605, 57967987, 58013017, 58025958, 58009197]
          ]
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
            [2022, 2023],
            [57372691, 57434589]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [57466250, 57437325, 57380883, 57297759, 57189759]
          ]
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
            [2022, 2023],
            [53033651, 53252598]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [53344401, 53642842, 53813850, 53958366, 54078360]
          ]
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
            [2022, 2023],
            [52843979, 53005102]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [53141509, 53257409, 53349628, 53419188, 53467663]
          ]
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
          isPredict: false,
          isInfo: false,
          data: [
            [2022, 2023],
            [57372691, 57434589]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [57466250, 57437325, 57380883, 57297759, 57189759]
          ]
        }
      ]
    },
    {
      screenId: 2,
      detailId: 1,
      detailSpot: 1,
      detailName: '广东省城镇养老保险未来收入和支出',
      minDataUnit: 2,  // 一个 detail 需要的最小数据单元数
      isMultiOption: false,
      detailData: [
        {
          dataId: 6,
          dataName: ["收入"],
          displayableMode: ["bar", "linear"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "亿元",
          numPrecision: '1',
          maxValue: 8000,
          minValue: 3000,
          dataColor: ['#2f89cf'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023],
            [6866, 6975]
          ],
          predictData: [
            [2024, 2025, 2026],
            [7164, 7384, 7607]
          ]
        },
        {
          dataId: 7,
          dataName: ["支出"],
          displayableMode: ["bar", "line"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "亿元",
          numPrecision: '1',
          maxValue: 8000,
          minValue: 3000,
          dataColor: ['#27d08a'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023],
            [3942, 4147]
          ],
          predictData: [
            [2024, 2025, 2026],
            [4338, 4556, 4795]
          ]
        }
      ]
    },
    {
      screenId: 2,
      detailId: 2,
      detailSpot: 2,
      detailName: '广东省城镇职工的参保人数',
      minDataUnit: 1,
      isMultiOption: false,
      detailData: [ // 注意！这是一个数组！数组里面是一个或多个JSON！
        {
          dataId: 8,
          dataName: ["参保人数"],   // 注意！这是一个数组！
          displayableMode: ["bar", "linear"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "亿人",
          numPrecision: '1.00', // 注意！这是一个字符串！
          maxValue: 1.4,
          minValue: 1.0,
          dataColor: ['#2f89cf'], // 注意！这里是一个数组！元素都是字符串！
          isPredict: true,
          isInfo: false,
          data: [ // 注意！这里是一个数组嵌套！
            [2022, 2023], // 注意！真数据和假数据分开放！
            [1.13, 1.15]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [1.20, 1.21, 1.25, 1.26, 1.28]
          ]
        }
      ]
    }
  ]
}