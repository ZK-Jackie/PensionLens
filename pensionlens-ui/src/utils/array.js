/**
 * @param {Array} arr 要被求和的数组
 * @returns {number} 数组元素的和
 * */
export function arraySum(arr){
  let sum = arr.reduce((acc, cur) => acc + cur, 0);
  return sum;
}