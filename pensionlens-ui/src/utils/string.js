/**
 * @param {string} originalString 原始字符串
 * @param {number} index 要被替换的位置
 * @param {string} replacement 替换的字符
 * @returns {string} 结果字符串
 */
export function replaceAt(originalString, index, replacement) {
  return originalString.substring(0, index) + replacement + originalString.substring(index + 1);
}

/**
 * @returns {string} UUID
 */
export function UUID() {
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
    var r = Math.random() * 16 | 0,
      v = c === 'x' ? r : (r & 0x3 | 0x8);
    return v.toString(16);
  });
}

/**
 * @param {string} str 字符串
 * @return {string} 移除非字母字符后的字符串
 */
export function removeNonLetters(str) {
  return str.replace(/[^a-zA-Z]/g, '');
}

/**
 * @param {string} str 字符串
 * @return {string} 首字母大写的字符串
 */
export function capitalizeFirstLetter(str) {
  return str.charAt(0).toUpperCase() + str.slice(1);
}

/**
 * @param {string} str 字符串
 * @return {boolean} 返回 true 如果首字母大写的字符串是 "True"；否则返回 false。
 * */
export function parseBoolean(str) {
  if (str === undefined || str === null) {
    return false;
  }
  const lowerStr = str.toLowerCase();
  if (lowerStr === "true") {
    return true;
  } else if (lowerStr === "false") {
    return false;
  }
  // 如果输入既不是 "true" 也不是 "false"，则返回 false
  return false;
}




export function toNumber(str){
  const num = parseFloat(str);
  return isNaN(num) ? null : num;
}