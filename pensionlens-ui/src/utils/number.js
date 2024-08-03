import {toNumber} from "@/utils/string";
/**
 * @param {number} value 原始数值
 * @param {string} format 后端返回的数值
 * @param num_format
 * @returns {number} 格式化后的数值
 * */
export function formatNumber(value, format, num_format=false) {
  // 检查后端返回的数值是否为负数
  let isNegative = format.startsWith('-');
  // 计算后端返回的数值的小数位数
  let decimalPart = format.split('.')[1] || '';
  // 计算有效数后有多少个0 -> 0的个数对应最终数据的精度
  // 将后端返回的字符串转换为数字
  let number = parseFloat(format);
  // 将原始数值乘以后端返回的数值的绝对值
  value *= Math.abs(number);
  // 格式化原始数值为相应的小数位数
  let cnt = countTrailingZeros(format)
  value = value.toFixed(cnt);
  // 如果后端返回的数值为负数，将结果转为负数
  if (isNegative) {
    value = '-' + value;
  }
  if (num_format){
    return toNumber(value);
  }
  return value;
}

/**
 * @param {string} str 字符串
 * @returns {number} 多余的零的数量
* */
export function countTrailingZeros(str) {
  // 检查字符串是否包含小数点
  if (str.includes('.')) {
    // 分割字符串为整数部分和小数部分
    let decimalPart = str.split('.')[1];
    // 反转小数部分并查找第一个非零字符的位置
    let nonZeroIndex = decimalPart.split('').reverse().join('').search(/[^0]/);
    // 如果没有找到非零字符，返回小数部分的长度，否则返回非零字符的位置
    return nonZeroIndex === -1 ? decimalPart.length : nonZeroIndex;
  } else {
    // 如果字符串不包含小数点，返回0
    return 0;
  }
}