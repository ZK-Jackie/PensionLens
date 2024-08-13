import request from '@/utils/request'
import {parseBoolean} from "@/utils/string";
import { Message } from 'element-ui';

const isOffline = parseBoolean(process.env.VUE_APP_IS_OFFLINE);
// 登录方法
export function login(username, password, code, uuid) {
    const data = {
        username,
        password,
        code,
        uuid
    }
    if (isOffline) {
        return request({
            url: '/login',
            headers: {
                isToken: false,
                repeatSubmit: false
            },
            method: 'post',
            data: data
        })
    } else {
        Message({
            showClose: true,
            message: '网络连接错误，请检查网络',
            type: 'error'
        });
    }
}

// 注册方法
export function register(data) {
    if (isOffline) {
        return request({
            url: '/register',
            headers: {
                isToken: false
            },
            method: 'post',
            data: data
        })
    }else {
        Message({
            showClose: true,
            message: '网络连接错误，请检查网络',
            type: 'error'
        });
    }
}

// 获取用户详细信息
export function getInfo() {
    if (isOffline) {
        return request({
            url: '/getInfo',
            method: 'get'
        })
    }else {
        Message({
            showClose: true,
            message: '网络连接错误，请检查网络',
            type: 'error'
        });
    }
}

// 退出方法
export function logout() {
    if (isOffline) {
        return request({
            url: '/logout',
            method: 'post'
        })
    }else {
        Message({
            showClose: true,
            message: '网络连接错误，请检查网络',
            type: 'error'
        });
    }
}

// 获取验证码
export function getCodeImg() {
    if (isOffline) {
        return request({
            url: '/captchaImage',
            headers: {
                isToken: false
            },
            method: 'get',
            timeout: 20000
        })
    }else {
        Message({
            showClose: true,
            message: '网络连接错误，请检查网络',
            type: 'error'
        });
    }
}
