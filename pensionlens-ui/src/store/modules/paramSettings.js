
import {paramScreenDetailList, modifierDefaultData} from "@/store/modules/defaultVal";

const param = {
  state: {
    paramScreenDetailList: [],
    paramDetails: [],
    tempOption: [],
    tempButton: []
  },
  mutations: {
    SET_PARAM_SCREEN_DETAIL_LIST: (state, paramScreenDetailList) => {
      state.paramScreenDetailList = paramScreenDetailList;
    },
    SET_PARAM_DETAILS: (state, param) => {
      state.paramDetails = param;
    },
    SET_TEMP_OPTION: (state, temp) => {
      state.tempOption = temp;
    },
    SET_TEMP_BUTTON: (state, temp) => {
      state.tempButton = temp;
    }
  },
  actions: {
    GetParamScreenDetailList({commit, dispatch}) {
      return new Promise((resolve, reject) => {
        const res = paramScreenDetailList;
        commit('SET_PARAM_SCREEN_DETAIL_LIST', res)
        resolve(res)
      })
    },
    GetParamDetails({commit, dispatch}, detailIds) {
      return new Promise((resolve, reject) => {
        const res = modifierDefaultData;
        commit('SET_PARAM_DETAILS', res);
        resolve(res)
      })
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


export default param;
