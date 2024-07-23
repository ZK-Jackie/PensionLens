
const getters = {
    detail: state => state.screen.detail,
    paramScreenDetailList: state => state.paramSettings.paramScreenDetailList,
    paramDetails: state => state.paramSettings.paramDetails,
    tempOption: state => state.paramSettings.tempOption,
    tempButton: state => state.paramSettings.tempButton,
    isLogin: state => state.user.isLogin,
}
export default getters