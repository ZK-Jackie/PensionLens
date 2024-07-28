export const nation_screen_info = {
  screenId: 2,
  screenName: '区域大屏',
  isPredict: false,
  isActive: true,
  screenPlan: [{
    screenId: 2,
    planId: null,
    priority: null,
  }],
  screenDetails: [
    {
      screenId: 0,
      detailId: 6,
      detailSpot: 1,
      detailName: '养老基金安全指数',
      minDataUnit: 1,
      isMultiOption: false,
      detailData: [
        {
          dataId: 16,
          dataName: ["基金安全指数"],
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
            ['低', '中', '高', '极高'],
            [0.2]
          ],
        }
      ]
    },
  ]
}