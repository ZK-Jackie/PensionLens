import Vue from 'vue'
import Vuex from 'vuex'
import screen from "./modules/screen"
import getters from "./getters"
import user from "../store/modules/user"
import modifierTemp from "@/store/modules/settings";

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    user,
    screen,
    modifierTemp
  },
  getters,
})

export default store
