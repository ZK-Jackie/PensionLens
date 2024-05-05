const temp = {
  state:{
    nowPlan: [],
  },
  mutations:{
    SET_NOW_PLAN: (state, plan) => {
      state.nowPlan = plan
    }
  },
  actions:{
    setNowPlan({ commit }, plan) {
      commit('SET_NOW_PLAN', plan)
    },
    calNowPlan({ commit }) {
      return new Promise((resolve, reject) =>{

      })
    }
  }
}

export default temp;
