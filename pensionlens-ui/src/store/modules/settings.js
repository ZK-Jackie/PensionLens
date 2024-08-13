import {getNewPreview} from "@/api/v2/settings";
import {new_local_screen_info} from "@/api/v2/data/screen_new_local";

const settings = {
  state: {
    modiOrigin: {},
    modiDetail: {},
    viewOrigin: {},
    viewTemp: {},
    isChangeSettings: false,
  },
  mutations: {
    SET_MODI_ORIGIN: (state, modiOrigin) => {
      state.modiOrigin = modiOrigin;
    },
    SET_MODI_DETAIL: (state, details) => {
      state.modiDetail = details;
    },
    SET_VIEW_ORIGIN: (state, viewOrigin) => {
      state.viewOrigin = viewOrigin;
    },
    SET_VIEW_TEMP: (state, viewTemp) => {
      state.viewTemp = viewTemp;
    },
    SET_CHANGE_SETTINGS: (state, isChangeSettings) => {
      state.isChangeSettings = isChangeSettings;
    },
  },
  actions: {
    // 提交修改后的数据
    CommitModiData({commit}, details) {
      commit('SET_MODI_DETAIL', details);
      // 打标
      commit('SET_CHANGE_SETTINGS', true);
      // 发送请求
      return Promise.resolve(new_local_screen_info.screenDetails);
      getNewPreview(details).then(response => {
        commit('SET_VIEW_TEMP', response.data);
      }).catch(error => {
        throw error;
      });
    }
  },
}


export default settings;
