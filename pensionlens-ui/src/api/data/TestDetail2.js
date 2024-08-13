export const barData = [
  {
    dataId: 1,
    displayMode: "bar",
    startTime: "2020",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 1,
      dataName: "收入",
      displayableMode: ["bar", "line"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "%",
      numPrecision: '100.0',
      maxValue: 600,
      minValue: 0,
      dataColor: ['#2f89cf'],
      isPredict: true,
      isInfo: false,
      data: [
        [2020, 2021, 2022, 2023, 2024, 2025, 2026],
        [0.101, 0.232, 300, 400, 500, 600, 700]
      ],
      // 经过index.vue处理过后新增的属性，其中——
      // 1. xAxisTags只放在第0个数据中,
      // 2. predictData出现过的内容不会再出现在上面的data中，第1个数据中同理
      // 3. data 和 predictData 都会变成 [[xAxisTagIndex1, 值1],[xAxisTagIndex2, 值2], ...]的形式
      // xAxisTags: [],
      // predictData: [
      //   [2024, 2025, 2026],
      //   [500, 400, 300]
      // ]
    }
  },
  {
    dataId: 2,
    displayMode: "bar",
    startTime: "2020",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 2,
      dataName: "支出",
      displayableMode: ["bar", "line"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.0',
      maxValue: 700,
      minValue: 100,
      dataColor: ['#27d08a'],
      isPredict: true,
      isInfo: false,
      data: [
        [2020, 2021, 2022, 2023, 2024, 2025, 2026],
        [700, 600, 500, 400, 300, 200, 100]
      ],
    }
  }
]

export const gaugeData = [
  {
    dataId: 1,
    displayMode: "gauge",
    startTime: null,
    endTime: null,
    predictStartTime: null,
    predictEndTime: null,
    chartOption: {
      dataId: 1,
      dataName: "gauge1",
      displayableMode: ["gauge"],
      keyLabel: null,
      keyUnit: null,
      valueLabel: null,
      valueUnit: null,
      numPrecision: '1.00',
      maxValue: 100,
      minValue: 0,
      dataColor: ['#7CFFB2', '#58D9F9', '#FDDD60', '#FF6E76'],
      isPredict: true,
      isInfo: true,
      data: [
        ['安全指数'],
        [0.2]
      ],
      xAxisTags: ['低', '中', '高', '极高'],
      // 经过index.vue处理过后，仅作基本的内容和合法性校验，数据层面不会发生任何变更
    }
  },
]

export const lineData = [
  {
    dataId: 1,
    displayMode: "linear",
    startTime: "2020",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 1,
      dataName: "series1",
      displayableMode: ["bar", "line"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '0.1',
      maxValue: 600,
      minValue: 0,
      dataColor: ['#2f89cf'],
      isPredict: true,
      isInfo: false,
      data: [
        [2020, 2021, 2022, 2023, 2024, 2025, 2026],
        [100, 200, 300, 400, 500, 600, 700]
      ],
      // 经过index.vue处理过后新增的属性，其中——
      // 1. xAxisTags只放在第0个数据中,
      // 2. predictData出现过的内容不会再出现在上面的data中，第1个数据中同理
      // 3. data 和 predictData 都会变成 [[xAxisTagIndex1, 值1],[xAxisTagIndex2, 值2], ...]的形式
      // xAxisTags: [],
      // predictData: [
      //   [2024, 2025, 2026],
      //   [500, 400, 300]
      // ]
    }
  },
  {
    dataId: 2,
    displayMode: "linear",
    startTime: "2020",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 2,
      dataName: "series2",
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1',
      maxValue: 700,
      minValue: 100,
      dataColor: ['#27d08a'],
      isPredict: true,
      isInfo: false,
      data: [
        [2020, 2021, 2022, 2023, 2024, 2025, 2026],
        [700, 600, 500, 400, 300, 200, 100]
      ]
    }
  }
]

export const pieData = [
  {
    dataId: 1,
    displayMode: "ring",
    startTime: "2020",
    endTime: "2023",
    predictStartTime: null,
    predictEndTime: null,
    chartOption: {
      dataId: 1,
      dataName: "series1",
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.0',
      maxValue: 600,
      minValue: 0,
      dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
      isPredict: false,
      isInfo: false,
      data: [
        [2020, 2021, 2022, 2023, 2024, 2025, 2026],
        [100, 200, 300, 400, 500, 600, 700]
      ],
      // 经过index.vue处理过后新增的属性，其中——
      // 1. xAxisTags只放在第0个数据中,
      // 2. predictData出现过的内容不会再出现在上面的data中，第1个数据中同理
      // 3. data 和 predictData 都会变成 [[xAxisTagIndex1, 值1],[xAxisTagIndex2, 值2], ...]的形式
      // xAxisTags: [],
      // predictData: [
      //   [2024, 2025, 2026],
      //   [500, 400, 300]
      // ]
    }
  }
]

export const mLineData = [
  {
    dataId: 1,
    displayMode: "mlinear",
    startTime: "2020",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 1,
      dataName: "series1",
      displayableMode: ["bar", "line"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "岁",
      numPrecision: '0.1',
      maxValue: 600,
      minValue: 0,
      dataColor: ['#2f89cf'],
      isPredict: false,
      isInfo: false,
      isDefault: true,
      data: [
        [2020, 2021, 2022, 2023, 2024, 2025, 2026],
        [56, 65, 65, 400, 500, 600, 700]
      ],
      // 经过index.vue处理过后新增的属性，其中——
      // 1. xAxisTags只放在第0个数据中,
      // 2. predictData出现过的内容不会再出现在上面的data中，第1个数据中同理
      // 3. data 和 predictData 都会变成 [[xAxisTagIndex1, 值1],[xAxisTagIndex2, 值2], ...]的形式
      // xAxisTags: [],
      // predictData: [
      //   [2024, 2025, 2026],
      //   [500, 400, 300]
      // ]
    }
  },
  {
    //2
  },
  {
    //3
  }
]

export const mSliderData = [
  {
    detailId: 1,
    dataId: 1,
    displayMode: "mslider",
    startTime: null,
    endTime: null,
    predictStartTime: null,
    predictEndTime: null,
    chartOption: {
      dataId: 1,
      dataName: "series1",
      displayableMode: ["bar", "line"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "年",
      numPrecision: '0.1',
      maxValue: 2030,
      minValue: 2024,
      dataColor: ['#2f89cf'],
      isPredict: false,
      isInfo: false,
      isDefault: true,
      data: [
        ['起始年份', '终止年份'],
        [2024, 2025]
      ],
      // 经过index.vue处理过后新增的属性，其中——
      // 1. xAxisTags只放在第0个数据中,
      // 2. predictData出现过的内容不会再出现在上面的data中，第1个数据中同理
      // 3. data 和 predictData 都会变成 [[xAxisTagIndex1, 值1],[xAxisTagIndex2, 值2], ...]的形式
      // xAxisTags: [],
      // predictData: [
      //   [2024, 2025, 2026],
      //   [500, 400, 300]
      // ]
    }
  }
]

export const RadarData1 = [//第一套每年人均过度养老金的数据
  {
    dataId: 1,
    displayMode: "radar",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 1,
      dataName: "老中人",
      displayableMode: ["radar"],
      numPrecision: '100.00',
      maxValue: 40000,
      minValue: 0,
      dataColor: ['#2f89cf'],
      isPredict: true,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [11593.98, 12646.32, 13445.69, 14473.18, 14069.35, 13567.43]
      ],
      indicator: [
        { name: '2021', max: 20000 },
        { name: '2022', max: 20000 },
        { name: '2023', max: 20000 },
        { name: '2024', max: 20000 },
        { name: '2025', max: 20000 },
        { name: '2026', max: 20000 }
      ]
    }
  },
  {
    dataId: 2,
    displayMode: "radar",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 2,
      dataName: "新中人",
      displayableMode: ["radar"],
      numPrecision: '100.00',
      maxValue: 50000,
      minValue: 0,
      dataColor: ['#2f89cf'],
      isPredict: true,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [15935.85, 16699.88, 17259.10, 17562.81, 17795.41, 18455.97]
      ],
      indicator: [
        { name: '2021', max: 20000},
        { name: '2022', max: 20000 },
        { name: '2023', max: 20000 },
        { name: '2024', max: 20000 },
        { name: '2025', max: 20000 },
        { name: '2026', max: 20000 }
      ]
    }
  }
]

export const RadarData2 = [//第二套每年人均过度养老金的数据
  {
    dataId: 1,
    displayMode: "radar",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 1,
      dataName: "老中人",
      displayableMode: ["radar"],
      numPrecision: '100.00',
      maxValue: 50000,
      minValue: 0,
      dataColor: ['#FF0000'],
      isPredict: true,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [11182.27, 12335.97, 12920.55, 14089.73, 13597.12, 13071.84]
      ],
      indicator: [
        { name: '2021', max: 20000 },
        { name: '2022', max: 20000 },
        { name: '2023', max: 20000 },
        { name: '2024', max: 20000 },
        { name: '2025', max: 20000 },
        { name: '2026', max: 20000 }
      ]
    }
  },
  {
    dataId: 2,
    displayMode: "radar",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 2,
      dataName: "新中人",
      displayableMode: ["radar"],
      numPrecision: '100.00',
      maxValue: 20000,
      minValue: 0,
      dataColor: ['#2f89cf'],
      isPredict: true,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [15748.282042, 16309.380083, 17027.769738, 17277.819386, 17798.944122, 18022.047985]
      ],
      indicator: [
        { name: '2021', max: 20000},
        { name: '2022', max: 20000 },
        { name: '2023', max: 20000 },
        { name: '2024', max: 20000 },
        { name: '2025', max: 20000 },
        { name: '2026', max: 20000 }
      ]
    }
  }
]


export const pieData_pension01 = [//第一套有关人均个人养老金的数据
  {
    dataId: 1,
    displayMode: "ring",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: null,
    predictEndTime: null,
    chartOption: {//人均－平均每月
      dataId: 1,
      dataName: "老中人",
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.00',
      maxValue: 4500,
      minValue: 0,
      dataColor: ['#2f89cf', '#2f99cf', '#2fa9cf', '#2fb9cf', '#2fc9cf', '#2fd9cf', '#2fe9cf', '#2ff9cf', '#2fffff'],
      isPredict: false,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [1027.60, 1119.51,1187.37, 1256.77, 1349.01, 1546.78]
      ],
    }
  }
  ]
export const pieData_pension02 = [//第一套有关人均个人养老金的数据
  {
    dataId: 1,
    displayMode: "ring",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: null,
    predictEndTime: null,
    chartOption: {//人均－平均每月
      dataId: 1,
      dataName: "新中人",
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.00',
      maxValue: 4500,
      minValue: 0,
      dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
      isPredict: false,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [2043.56, 2335.36, 2639.52, 2840.67, 2910.34, 2950.43]
      ],
    }
  }
  ]
export const pieData_pension03 = [//第一套有关人均个人养老金的数据
  {
    dataId: 1,
    displayMode: "ring",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: null,
    predictEndTime: null,
    chartOption: {//人均－平均每月
      dataId: 1,
      dataName: "新人",
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.00',
      maxValue: 20000,
      minValue: 0,
      dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
      isPredict: false,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [1637.34,2043.56,2335.57,2335.37,2639.52,2947.16]
      ],
    }
  }
]

export const pieData_pension04 = [//第二套有关个人养老金的数据
  {
    dataId: 1,
    displayMode: "ring",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: null,
    predictEndTime: null,
    chartOption: {//人均－平均每月
      dataId: 1,
      dataName: "老中人",
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.00',
      maxValue: 4500,
      minValue: 0,
      dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
      isPredict: false,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [1127.60, 1249.51, 1277.37, 1356.77, 1469.01, 1686.78]
      ],
    }
  }
  ]
export const pieData_pension05 = [//第二套有关人均个人养老金的数据
  {
    dataId:  1,
    displayMode: "ring",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: null,
    predictEndTime: null,
    chartOption: {//人均－平均每月
      dataId: 1,
      dataName: "新中人",
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.00',
      maxValue: 4500,
      minValue: 0,
      dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
      isPredict: false,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [2243.56, 2535.36, 2939.52, 3140.67, 3210.34, 3450.43]
      ],
    }
  }
  ]
export const pieData_pension06 = [//第二套有关个人养老金的数据
  {
    dataId: 1,
    displayMode: "ring",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: null,
    predictEndTime: null,
    chartOption: {//人均－平均每月
      dataId: 1,
      dataName: "新人",
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.00',
      maxValue: 20000,
      minValue: 0,
      dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
      isPredict: false,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [1769.01, 1837.34, 2243.56, 2535.57, 2535.37, 2949.52, 3257.16]
      ],
    }
  }
]

export const lineData_basic = [//第一套基础养老金数据
  {
    dataId: 1,
    displayMode: "linear",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 1,
      dataName: "老人-老中人",//人均－每个月
      displayableMode: ["bar", "line"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.00',
      maxValue: 4500,
      minValue: 800,
      dataColor: ['#2f89cf'],
      isPredict: true,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [3041.97, 3360.37, 3419.66, 3527.58, 3733.30, 3988.76]
      ],
    }
  },
  {
    dataId: 2,
    displayMode: "linear",
    startTime: "2020",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 2,
      dataName: "新中人-新人",//人均－每个月
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1',
      maxValue: 4500,
      minValue: 800,
      dataColor: ['#27d08a'],
      isPredict: true,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [3023.76,3189.87, 3528.29, 3716.34, 4367.76, 4773.91]
      ]
    }
  },
]

export const lineData_basic01 = [//第二套基础养老金数据
  {
    dataId: 1,
    displayMode: "linear",
    startTime: "2021",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 1,
      dataName: "老人-老中人",//人均－每个月
      displayableMode: ["bar", "line"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1.00',
      maxValue: 4500,
      minValue: 800,
      dataColor: ['#2f89cf'],
      isPredict: true,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [3341.97, 3660.37, 3719.66, 3827.58, 4033.30, 4288.76]
      ],
    }
  },
  {
    dataId: 2,
    displayMode: "linear",
    startTime: "2020",
    endTime: "2026",
    predictStartTime: "2024",
    predictEndTime: "2026",
    chartOption: {
      dataId: 2,
      dataName: "新中人-新人",//人均－每个月
      displayableMode: ["bar", "line", "ring"],
      keyLabel: "x",
      keyUnit: "年",
      valueLabel: "y",
      valueUnit: "元",
      numPrecision: '1',
      maxValue: 4500,
      minValue: 800,
      dataColor: ['#27d08a'],
      isPredict: true,
      isInfo: false,
      data: [
        [2021, 2022, 2023, 2024, 2025, 2026],
        [3123.76, 3289.87, 3628.29, 3816.34, 4467.76, 4873.91]
      ]
    }
  },
]

export const testData= [barData, gaugeData, lineData, pieData, mLineData, mSliderData,RadarData2,pieData_pension01,pieData_pension02,pieData_pension03,pieData_pension04,pieData_pension05,pieData_pension06,lineData_basic,lineData_basic01,RadarData1]