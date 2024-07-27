import {getScreenDetails, getScreenInfo} from "@/api/v2/screen";
import {screenInfo} from "@/api/v2/data/screen_local";

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
    SET_SCREEN_DETAIL: (state, screenId, details) => {
      state[screenId] = details;
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
    },
    GetScreenDetail({commit}, screenId) {
      commit('SET_SCREEN_DETAIL', screenId, screenInfo.screenDetails);
      return new Promise((resolve, reject) => {
        resolve(screenInfo.screenDetails);
      })
      return getScreenDetails(screenId).then(response => {
        commit('SET_DETAIL', response.data);
        return response.data;
      }).catch(error => {
        throw error;
      });
    },
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
