import {getScreenDetails, getScreenInfo} from "@/api/v2/screen";
import {nation_screen_info} from "@/api/v2/data/screen_nation";
import {local_screen_info} from "@/api/v2/data/screen_local";
import {default_settings_screen_info} from "@/api/v2/data/screen_settings_default";
import store from '@/store'
import {new_local_screen_info} from "@/api/v2/data/screen_new_local";

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
      if (screenId === 0){
        commit('SET_SCREEN_DETAIL', screenId, nation_screen_info.screenDetails);
        return new Promise((resolve, reject) => {
          resolve(nation_screen_info.screenDetails);
        })
      }else if (screenId === 2){
        console.log("local req");
        console.log(store.getters.isChangeSettings);
        if (store.getters.isChangeSettings){
          commit('SET_SCREEN_DETAIL', screenId, new_local_screen_info.screenDetails);
          return new Promise((resolve, reject) => {
            resolve(new_local_screen_info.screenDetails);
          })
        }
        commit('SET_SCREEN_DETAIL', screenId, local_screen_info.screenDetails);
        return new Promise((resolve, reject) => {
          resolve(local_screen_info.screenDetails);
        })
      }else if (screenId === 4){
        commit('SET_SCREEN_DETAIL', screenId, default_settings_screen_info.screenDetails);
        return new Promise((resolve, reject) => {
          resolve(default_settings_screen_info.screenDetails);
        })
      }
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
