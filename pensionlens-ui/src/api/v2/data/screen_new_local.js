// 承接 screen_nation.js，
// 本文 dataId 从 17 开始，detailId 从 7 开始。这些 id 在本文前没被使用过
// 当前用户可访问的大屏信息
// 0-全国大屏，1-政策大屏，2-区域大屏，3-配置后的新数据大屏/实时更新屏，4-参数调配区域
export const new_local_screen_info = {
  screenId: 3,
  screenName: '广东省区域大屏信息',
  isPredict: false,
  isActive: true,
  screenPlan: [{
    screenId: 3,
    planId: null,
    priority: null,
  }],
  screenDetails: [
    {
      screenId: 3,
      detailId: 7,
      detailSpot: 0,
      minDataUnit: 1,
      detailName: '不同生育模式下不同年龄的人数预测情况',
      isMultiOption: true,
      detailData: [
        {
          dataId: 17,
          dataName: ['男', '高生育模式'],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 55000000,
          dataColor: ['#800080', '#9932CC', '#9400D3', '#8A2BE2', '#9370DB', '#BA55D3', '#D8BFD8', '#DDA0DD', '#EE82EE'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023],
            [57882505, 58095864]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [58271040, 58448537, 58585040, 5869112, 5849285]
          ]
        },
        {
          dataId: 18,
          dataName: ['男', '中生育模式'],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 50000000,
          dataColor: ['#800080', '#9932CC', '#9400D3', '#8A2BE2', '#9370DB', '#BA55D3', '#D8BFD8', '#DDA0DD', '#EE82EE'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023],
            [57639312, 57781721]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [5789605, 57977987, 58033017, 58095958, 58010197]
          ]
        },
        {
          dataId: 19,
          dataName: ['男', '低生育模式'],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 50000000,
          dataColor: ['#800080', '#9932CC', '#9400D3', '#8A2BE2', '#9370DB', '#BA55D3', '#D8BFD8', '#DDA0DD', '#EE82EE'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023],
            [57382691, 57494589]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [57576250, 57637325, 57480883, 57397759, 57129759]
          ]
        },
        {
          dataId: 20,
          dataName: ['女', '高生育模式'],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 50000000,
          dataColor: ['#800080', '#9932CC', '#9400D3', '#8A2BE2', '#9370DB', '#BA55D3', '#D8BFD8', '#DDA0DD', '#EE82EE'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023],
            [53033651, 53252598]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [533944014, 53682842, 53833850, 53960366, 54098360]
          ]
        },
        {
          dataId: 21,
          dataName: ['女', '中生育模式'],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 55000000,
          dataColor: ['#800080', '#9932CC', '#9400D3', '#8A2BE2', '#9370DB', '#BA55D3', '#D8BFD8', '#DDA0DD', '#EE82EE'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023],
            [52857979, 53055102]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [53141509, 53357409, 53399628, 53479188, 535676638]
          ]
        },
        {
          dataId: 22,
          dataName: ['女', '低生育模式'],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "人",
          numPrecision: '1',
          maxValue: 65000000,
          minValue: 50000000,
          dataColor: ['#800080', '#9932CC', '#9400D3', '#8A2BE2', '#9370DB', '#BA55D3', '#D8BFD8', '#DDA0DD', '#EE82EE'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023],
            [52727211, 52792248]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [52805789, 52812717, 52830400, 52820536, 5290220]
          ]
        }
      ]
    },
    {
      screenId: 3,
      detailId: 8,
      detailSpot: 1,
      detailName: '广东省城镇养老保险未来收入和支出',
      minDataUnit: 2,  // 一个 detail 需要的最小数据单元数
      isMultiOption: false,
      detailData: [
        {
          dataId: 23,
          dataName: ["收入"],
          displayableMode: ["bar", "linear"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "亿元",
          numPrecision: '1',
          maxValue: 8000,
          minValue: 3000,
          dataColor: ['#800080'],
          isPredict: true,
          isInfo: false,
          data: [
            [2022, 2023],
            [6866, 6975]
          ],
          predictData: [
            [2024, 2025, 2026],
            [7214, 7424, 7637]
          ]
        },
        {
          dataId: 24,
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
            [4398, 4611, 4821]
          ]
        }
      ]
    },
    {
      screenId: 3,
      detailId: 9,
      detailSpot: 2,
      detailName: '广东省城镇职工的参保人数',
      minDataUnit: 1,
      isMultiOption: false,
      detailData: [ // 注意！这是一个数组！数组里面是一个或多个JSON！
        {
          dataId: 25,
          dataName: ["参保人数"],   // 注意！这是一个数组！
          displayableMode: ["bar", "linear"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "亿人",
          numPrecision: '1.00', // 注意！这是一个字符串！
          maxValue: 1.4,
          minValue: 1.0,
          dataColor: ['#800080'], // 注意！这里是一个数组！元素都是字符串！
          isPredict: true,
          isInfo: false,
          data: [ // 注意！这里是一个数组嵌套！
            [2022, 2023], // 注意！真数据和假数据分开放！
            [1.13, 1.15]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028],
            [1.21, 1.23, 1.26, 1.27, 1.29]
          ]
        }
      ]
    },
    {
      screenId: 3,
      detailId: 10,
      detailSpot: 3,
      detailName: '人均基本养老金变化',
      minDataUnit: 2,
      isMultiOption: false,
      detailData: [
        {
          dataId: 26,
          dataName: ["老人"],
          displayableMode: ["linear-climb"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "元",
          numPrecision: '1',
          maxValue: 5000,
          minValue: 2000,
          dataColor: ['#800080'],
          isPredict: true,
          isInfo: false,
          data: [
            [1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023],
            [2500, 2520.745073, 2541.490328, 2562.330963, 2583.273314, 2604.324757, 2625.492768, 2646.785951, 2668.212, 2698.768, 2729.358, 2760.891, 2793.276, 2826.422, 2860.236, 2894.624, 2929.49, 2964.738, 3000.272, 3036.997, 3041.303034, 3059.753114, 3132.516089, 3158.214632, 3184.408898, 3207.906429, 3224.243529, 3360.326076, 3372.301117, 3379.165534, 3390.096746, 3400.5203, 3407.24508, 3419.660504, 3429.511817, 3438.196222, 3454.034383, 3457.949172, 3527.582649, 3733.30879, 3750.970306144571, 3802.9668449833366, 3843.219791632037, 3891.019460436632]
          ],
          predictData: [
            [2024, 2025, 2026, 2027, 2028, 2029, 2030],
            [3827.58, 4033.30, 4288.76, 4399.118788861138, 4437.121784183962, 4489.989437501258, 4538.312195086258]
          ]
        },
        {
          dataId: 27,
          dataName: ["青年人"],
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
            [3816.34, 4467.76, 4873.91, 4976.582768, 4940.900951, 5056.67, 5200.19]
          ]
        }
      ]
    },
    {
      screenId: 3,
      detailId: 11,
      detailSpot: 4,
      detailName: '人均个人养老金情况',
      minDataUnit: 1,
      isMultiOption: true,
      detailData: [
        {
          dataId: 28,
          dataName: ["老中人"],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "元",
          numPrecision: '1.00',
          maxValue: 4500,
          minValue: 0,
          dataColor: ['#800080', '#9932CC', '#9400D3', '#8A2BE2', '#9370DB', '#BA55D3', '#D8BFD8', '#DDA0DD', '#EE82EE'],
          isPredict: true,
          isInfo: false,
          data: [
            [2021, 2022, 2023],
            [1027.60, 1119.51, 1187.37]
          ],
          predictData: [
            [2024, 2025, 2026],
            [1356.77, 1469.01, 1686.78]
          ]
        },
        {
          dataId: 29,
          dataName: ["新中人"],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "元",
          numPrecision: '1.00',
          maxValue: 4500,
          minValue: 0,
          dataColor: ['#800080', '#9932CC', '#9400D3', '#8A2BE2', '#9370DB', '#BA55D3', '#D8BFD8', '#DDA0DD', '#EE82EE'],
          isPredict: true,
          isInfo: false,
          data: [
            [2021, 2022, 2023],
            [2043.56, 2335.36, 2639.52]
          ],
          predictData: [
            [2024, 2025, 2026],
            [3140.67, 3210.34, 3450.43]
          ]
        },
        {
          dataId: 30,
          dataName: ["新人"],
          displayableMode: ["bar", "linear", "ring"],
          keyLabel: "x",
          keyUnit: "年",
          valueLabel: "y",
          valueUnit: "元",
          numPrecision: '1.00',
          maxValue: 20000,
          minValue: 0,
          dataColor: ['#800080', '#9932CC', '#9400D3', '#8A2BE2', '#9370DB', '#BA55D3', '#D8BFD8', '#DDA0DD', '#EE82EE'],
          isPredict: true,
          isInfo: false,
          data: [
            [2021, 2022, 2023],
            [1637.34, 2043.56, 2335.57]
          ],
          predictData: [
            [2024, 2025, 2026],
            [2535.37, 2949.52, 3257.16]
          ]
        },
      ]
    },
    {
      screenId: 3,
      detailId: 12,
      detailSpot: 5,
      detailName: '人均过渡养老金情况',
      minDataUnit: 2,
      isMultiOption: false,
      detailData: [
        {
          dataId: 31,
          dataName: ["老中人"],
          displayableMode: ["radar"],
          numPrecision: '100.00',
          maxValue: 20000,
          minValue: 0,
          dataColor: ['#FF0000'],
          isPredict: true,
          isInfo: false,
          data: [
            [2021, 2022, 2023],
            [11593.98, 12646.32, 13445.69]
          ],
          predictData: [
            [2024, 2025, 2026],
            [14089.73, 13597.12, 13071.84]
          ]
        },
        {
          dataId: 32,
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
            [17277.819386, 17798.944122, 18022.047985]
          ]
        }
      ]
    }
  ]
}