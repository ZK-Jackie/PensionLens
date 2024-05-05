

const screen = {
  state: {
    template: {},
    detail: {},
    data: []
  },
  mutations: {
    SET_TEMPLATE: (state, template) => {
      state.template = template;
    },
    SET_DETAIL: (state, detail) => {
      state.detail = detail;
    },
    SET_DETAIL_DATA: (state, data) => {
      state.detail[0].data[0].chatOption = data[0];
      state.detail[0].data[1].chatOption = data[1];
    },
    SET_DATA: (state, data) => {
      state.data = data;
    }
  },
  actions: {
    GetActiveTemplate({commit, dispatch}) {
      return new Promise((resolve, reject) => {
        const res = {
          screenId: 1,
          screenName: "模板1",
          isPredict: true,
          isActive: true,
          detailIds: [1, 2, 3, 4, 5, 6, 7]
        }
        commit('SET_TEMPLATE', res)
        dispatch('GetDetail',res.detailIds).then(r => resolve(r)).catch(e => reject(e));
      })
    },
    GetDetail({commit, dispatch}, detailIds) {
      return new Promise((resolve, reject) => {
        const res = [{
          screenId: 1,
          detailId: 1,
          detailSpot: 1,
          detailName: "模块1",
          data: [
            {
              dataId: 1,
              displayMode: "bar",
              startTime: "2020",
              endTime: "2026",
              predictStartTime: "2024",
              predictEndTime: "2026",
              chartOption:{}
            },
            {
              dataId: 2,
              displayMode: "bar",
              startTime: "2020",
              endTime: "2026",
              predictStartTime: "2024",
              predictEndTime: "2026",
              chartOption: {}
            }
          ]
        }]
        commit('SET_DETAIL', res);
        dispatch('GetCharts',extractDataIds(res)).then(r => resolve(r)).catch(e => reject(e));
      })
    },
    GetCharts({commit}, dataIds) {
      return new Promise((resolve, reject) => {
        const res = [
          {
            dataId: 1,
            dataName: "series1",
            displayableMode: ["bar", "line"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "元",
            numPrecision: 1.0,
            maxValue: 800,
            minValue: 0,
            dataColor: '#2f89cf',
            isPredict: true,
            isInfo: false,
            data: [
              [2020, 2021, 2022, 2023, 2024, 2025, 2026],
              [100, 200, 300, 400, 500, 600, 700]
            ]
          },
          {
            dataId: 2,
            dataName: "series2",
            displayableMode: ["bar", "line"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "元",
            numPrecision: 1.00,
            maxValue: 700,
            minValue: 100,
            dataColor: '#27d08a',
            isPredict: false,
            isInfo: false,
            data: [
              [2020, 2021, 2022, 2023, 2024, 2025, 2026],
              [700, 600, 500, 400, 300, 200, 100]
            ]
          }
        ]
        console.log(res)
        commit('SET_DETAIL_DATA', res);
        commit('SET_DATA', res);
        resolve(res)
      })
    }
  }
}

function extractDataIds(details) {
  let dataIds = []
  details.forEach(detail => {
    detail.data.forEach(data => {
      dataIds.push(data.dataId)
    })
  })
  return dataIds
}

export default screen;
