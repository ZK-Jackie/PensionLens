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
      dataName: "series1",
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
      dataName: "series2",
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
      ]
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

export const testData= [barData, gaugeData, lineData, pieData, mLineData, mSliderData];
export const previewTestData= [barData, gaugeData, lineData, pieData];