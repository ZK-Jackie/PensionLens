import {getScreenDetails, getScreenInfo} from "@/api/v2/screen";


const screen = {
  state: {
    screenInfo: {},
    detail: {},
    data: []
  },
  mutations: {
    SET_SCREEN_INFO: (state, template) => {
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
    GetScreenInfo({commit}) {
      return getScreenInfo().then(response => {
        commit('SET_SCREEN_INFO', response.data);
      }).catch(error => {
        throw error;
      });
    }
  },
  GetScreenDetail({commit}, detailId) {
    return getScreenDetails(detailId).then(response => {
      commit('SET_DETAIL', response.data);
      return response.data;
    }).catch(error => {
      throw error;
    });
  },
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
