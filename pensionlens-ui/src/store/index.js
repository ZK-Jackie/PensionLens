import Vue from 'vue'
import Vuex from 'vuex'
import screen from "./modules/screen"
import paramSettings from "./modules/paramSettings"
import temp from "./modules/temp"
import getters from "./getters"
import user from "../store/modules/user"

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    user,
    screen,
    paramSettings,
    temp
  },
  getters,
})

export default store
