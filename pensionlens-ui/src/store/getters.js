const getters = {
    detail: state => state.screen.detail,
    isLogin: state => state.user.isLogin,
    isChangeSettings: state => state.settings.isChangeSettings,
}

export default getters