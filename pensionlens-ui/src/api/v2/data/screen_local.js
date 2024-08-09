// 当前用户可访问的大屏信息
// 0-全国大屏，1-政策大屏，2-区域大屏，3-配置大屏
export const local_screen_info = {
  screenId: 2,
  screenName: '广东省区域大屏信息',
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
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 55000000,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: true,
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
          displayableMode: ["bar", "linear", "ring"],
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
          displayableMode: ["bar", "linear", "ring"],
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
          displayableMode: ["bar", "linear", "ring"],
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
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 55000000,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: true,
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
          displayableMode: ["bar", "linear", "ring"],
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
          displayableMode: ["bar", "linear"],
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
    },
    {
      screenId: 2,
      detailId: 3,
      detailSpot: 3,
      detailName: '人均基本养老金变化',
      minDataUnit: 2,
      isMultiOption: false,
      detailData: [
        {
          dataId: 9,
          dataName: ["老人"],
          displayableMode: ["linear-climb"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "元",
          numPrecision: '1',
          maxValue: 5000,
          minValue: 2000,
          dataColor: ['#2f89cf'],
          isPredict: true,
          isInfo: false,
          data: [
            [1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023],
            [2500, 2520.745073, 2541.490328, 2562.330963, 2583.273314, 2604.324757, 2625.492768, 2646.785951, 2668.212, 2698.768, 2729.358, 2760.891, 2793.276, 2826.422, 2860.236, 2894.624, 2929.49, 2964.738, 3000.272, 3036.997, 3041.303034, 3059.753114, 3132.516089, 3158.214632, 3184.408898, 3207.906429, 3224.243529, 3360.326076, 3372.301117, 3379.165534, 3390.096746, 3400.5203, 3407.24508, 3419.660504, 3429.511817, 3438.196222, 3454.034383, 3457.949172, 3527.582649, 3733.30879, 3750.970306144571, 3802.9668449833366, 3843.219791632037, 3891.019460436632]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028, 2029, 2030],
            [3969.805946027576, 4010.5694425049355, 4049.303562777233, 4099.118788861138, 4137.121784183962, 4189.989437501258, 4238.312195086258]
          ]
        },
        {
          dataId: 10,
          dataName: ["新人"],
          displayableMode: ["linear-climb"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "元",
          numPrecision: '1',
          maxValue: 5000,
          minValue: 2000,
          dataColor: ['#27d08a'],
          isPredict: true,
          isInfo: false,
          data: [
            [1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023],
            [2142.026648, 2149.156329, 2156.288722, 2163.423827, 2170.561644, 2177.702173, 2184.845415, 2191.99137, 2199.140038, 2206.291419, 2213.445514, 2220.602321, 2227.761842, 2234.924076, 2242.089023, 2249.256684, 2256.427058, 2263.600146, 2270.775948, 2277.954463, 2285.135692, 2142.026648, 2148.0744, 2153.533228, 2158.250077, 2173.365419, 2210.458872, 2257.941379, 2315.558098, 2383.754566, 2462.210945, 2550.741129, 2649.579236, 2758.471153, 2877.368215, 3006.238848, 3144.159682, 3290.017097, 3442.899714, 3601.297897, 3763.304702, 3926.714687, 4090.523963, 4154.829073, 4219.126328]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028, 2029, 2030],
            [4383.312963, 4547.686314, 4612.143757, 4776.582768, 4840.900951, 4856.67, 5000.19]
          ]
        }
      ]
    },
    {
      screenId: 2,
      detailId: 4,
      detailSpot: 4,
      detailName: '人均个人养老金情况',
      minDataUnit: 1,
      isMultiOption: true,
      detailData: [
        {
          dataId: 11,
          dataName: ["老中人"],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "元",
          numPrecision: '1.00',
          maxValue: 4500,
          minValue: 0,
          dataColor: ['#2f89cf', '#2f99cf', '#2fa9cf', '#2fb9cf', '#2fc9cf', '#2fd9cf', '#2fe9cf', '#2ff9cf', '#2fffff'],
          isPredict: true,
          isInfo: false,
          data: [
            [2021, 2022, 2023],
            [1027.60, 1119.51, 1187.37]
          ],
          predictData: [
            [2024, 2025, 2026],
            [1256.77, 1349.01, 1546.78]
          ]
        },
        {
          dataId: 12,
          dataName: ["新中人"],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "元",
          numPrecision: '1.00',
          maxValue: 4500,
          minValue: 0,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: true,
          isInfo: false,
          data: [
            [2021, 2022, 2023],
            [2043.56, 2335.36, 2639.52]
          ],
          predictData: [
            [2024, 2025, 2026],
            [2840.67, 2910.34, 2950.43]
          ]
        },
        {
          dataId: 13,
          dataName: ["新人"],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "元",
          numPrecision: '1.00',
          maxValue: 20000,
          minValue: 0,
          dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
          isPredict: true,
          isInfo: false,
          data: [
            [2021, 2022, 2023],
            [1637.34, 2043.56, 2335.57]
          ],
          predictData: [
            [2024, 2025, 2026],
            [2335.37, 2639.52, 2947.16]
          ]
        },
      ]
    },
    {
      screenId: 2,
      detailId: 5,
      detailSpot: 5,
      detailName: '人均过渡养老金情况',
      minDataUnit: 2,
      isMultiOption: false,
      detailData: [
        {
          dataId: 14,
          dataName: ["老中人"],
          displayableMode: ["radar"],
          numPrecision: '100.00',
          maxValue: 20000,
          minValue: 0,
          dataColor: ['#2f89cf'],
          isPredict: true,
          isInfo: false,
          data: [
            [2021, 2022, 2023],
            [11593.98, 12646.32, 13445.69]
          ],
          predictData:[
            [2024, 2025, 2026],
            [14473.18, 14069.35, 13567.43]
          ]
        },
        {
          dataId: 15,
          dataName: ["新中人"],
          displayableMode: ["radar"],
          numPrecision: '100.00',
          maxValue: 20000,
          minValue: 0,
          dataColor: ['#27d08a'],
          isPredict: true,
          isInfo: false,
          data: [
            [2021, 2022, 2023],
            [15935.85, 16699.88, 17259.10]
          ],
          predictData: [
            [2024, 2025, 2026],
            [17562.81, 17795.41, 18455.97]
          ]
        }
      ]
    }
  ]
}