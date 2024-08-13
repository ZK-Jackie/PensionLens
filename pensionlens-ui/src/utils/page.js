/**
* @param {number} px 像素单位
* @returns {number} rem rem单位
* */
function pxToRem(px) {
  const fontSize = parseFloat(this.window.getComputedStyle(document.documentElement).fontSize);
  return px / fontSize;
}

/**
 * @param {number} rem rem单位
 * @returns {number} px 像素单位
 */
function remToPx(rem) {
  const fontSize = parseFloat(this.window.getComputedStyle(document.documentElement).fontSize);
  return rem * fontSize;
}