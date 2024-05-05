import request from '@/utils/request'
import {parseBoolean} from "@/utils/string";
// 用自己做的axios封装从后端获取路由信息
import {BasicPension} from "@/api/data/BasicPension";
import {Policies} from "@/api/data/Policies.js";
import {WordFrequency} from "@/api/data/WordFrequency";
import {previewTestData} from "@/api/data/TestDetail";
import {H_population101, M_population102, L_population103, RadarData1} from '@/api/data/gdData1.js';
import {
  income_and_expense02,
  participants02,
  H_population201,
  L_population203,
  M_population202,
  pieData_pension201,
  RadarData2,
  pieData_pension202,
  pieData_pension203,
  lineData_basic01
} from "@/api/data/gdData2";
import {income_and_expense01, participants01} from "@/api/data/gdData";
import {
  pieData_pension01,
  pieData_pension02,
  pieData_pension03,
} from "@/api/data/TestDetail2";
import {barData} from "@/api/data/TestDetail2";
import {lineData} from "@/api/data/TestDetail2";
import {pieData} from "@/api/data/TestDetail2";


const isOffline = parseBoolean(process.env.VUE_APP_IS_OFFLINE);

// 查询区域大屏的数据
export function getBasicPension() {
  if (isOffline) {
    return Promise.resolve({
      code: 200,
      message: 'success',
      data: BasicPension
    })
  } else {
    return request({
      url: '/data/basicPension',
      headers: {
        isToken: false
      },
      method: 'get',
      timeout: 20000
    })
  }
}


// 查询政策大屏政策的数据
export function getPolicyGraph() {
  if (isOffline) {
    return Promise.resolve({
      code: 200,
      message: 'success',
      data: Policies
    })
  }else {
    return request({
      url: '/data/policyGraph',
      headers: {
        isToken: false
      },
      method: 'get',
      timeout: 20000
    })
  }
}

// 查询政策大屏词云的数据
export function getPensionWordFreq() {
  if(isOffline){
    return Promise.resolve({
      code: 200,
      message: 'success',
      data: WordFrequency
    })
  }else {
    return request({
      url: '/data/pensionWordFreq',
      headers: {
        isToken: false
      },
      method: 'get',
      timeout: 20000
    })
  }
}

// 查询参数调配大屏的数据
export function getCalPreview() {
  if(isOffline){
    return Promise.resolve({
      code: 200,
      message: 'success',
      data: {
        H_population101,
        M_population102,
        L_population103,
        H_population201,
        M_population202,
        L_population203,
        income_and_expense01,
        participants01,
        pieData_pension01,
        pieData_pension02,
        pieData_pension03,
        RadarData1,
        RadarData2,
        income_and_expense02,
        participants02,
        pieData_pension201,
        pieData_pension202,
        pieData_pension203,
        lineData_basic01
      }
    })
  }else {
    return request({
      url: '/data/calPreview',
      headers: {
        isToken: false
      },
      data:{
        //modifier data
      },
      method: 'post',
      timeout: 20000
    })
  }
}

// 查询参数调配大屏的数据
export function getNowPreview() {
  if(isOffline){
    return Promise.resolve({
      code: 200,
      message: 'success',
      data: previewTestData
    })
  }else {
    return request({
      url: '/data/nowPreview',
      headers: {
        isToken: false
      },
      method: 'get',
      timeout: 20000
    })
  }
}

// 查询区域大屏的数据
export function getRegionData() {
  if(isOffline){
    return Promise.resolve({
      code: 200,
      message: 'success',
      data: {
        H_population101,
        M_population102,
        L_population103,
        H_population201,
        M_population202,
        L_population203,
        income_and_expense01,
        participants01,
        pieData_pension01,
        pieData_pension02,
        pieData_pension03,
        RadarData1,
        RadarData2,
        income_and_expense02,
        participants02,
        pieData_pension201,
        pieData_pension202,
        pieData_pension203,
        lineData_basic01
      }
    })
  }else {
    return request({
      url: '/data/regin',
      headers: {
        isToken: false
      },
      method: 'get',
      timeout: 20000
    })
  }
}
