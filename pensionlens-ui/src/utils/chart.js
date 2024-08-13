import {formatNumber} from "@/utils/number";

export function toOptions(details) {
  // 0. check if the data is basically valid
  isValid(details);
  let ret = [];
  if(details[0].chartOption.isInfo){
    details[0].chartOption.isOK = true;
    ret.push(details[0].chartOption);
    return ret;
  }else if(details[0].chartOption.isDefault){
    truncateKeys(details);
    mergeData(details);
    modifyExtremum(details);
    details[0].chartOption.data = toEchartsData(details[0].chartOption.data, details[0].chartOption.xAxisTags, details[0].chartOption.numPrecision, details[0].chartOption.valueUnit);
    details[0].chartOption.isOK = true;
    ret.push(details[0].chartOption);
    return ret;
  }else{
    // 1. truncate the keys
    truncateKeys(details);
    // 2. merge keys and max/min value res
    mergeData(details);
    // 3. extract predict data
    extractPredict(details);
    // 4. modify extremum
    modifyExtremum(details);
    // 5. formatter the data that echarts can directly use
    details[0].chartOption.isOK = true;
    details[0].chartOption.data = toEchartsData(details[0].chartOption.data, details[0].chartOption.xAxisTags, details[0].chartOption.numPrecision, details[0].chartOption.valueUnit);
    if (details[0].chartOption.isPredict && details[0].chartOption.predictData !== undefined || details[0].chartOption.predictData !== null)
      details[0].chartOption.predictData = toEchartsData(details[0].chartOption.predictData, details[0].chartOption.xAxisTags, details[0].chartOption.numPrecision, details[0].chartOption.valueUnit);
    ret.push(details[0].chartOption);
    if (details.length === 2) {
      details[1].chartOption.data = toEchartsData(details[1].chartOption.data, details[0].chartOption.xAxisTags, details[1].chartOption.numPrecision, details[1].chartOption.valueUnit);
      if (details[0].chartOption.isPredict && details[0].chartOption.predictData !== undefined || details[0].chartOption.predictData !== null)
        details[1].chartOption.predictData = toEchartsData(details[1].chartOption.predictData, details[0].chartOption.xAxisTags, details[1].chartOption.numPrecision, details[1].chartOption.valueUnit);
      ret.push(details[1].chartOption);
    }
    return ret;
  }
}

export function toEchartsData(data, keyIndexMap, valuePrecision, valueUnit, isMapping = true) {
  if (data === undefined) return;
  let echartsData = [];
  let keys = data[0];
  let values = data[1];
  for (let i = 0; i < keys.length; i++) {
    let tempDataItem = [];
    // For safety, use index instead of the name of the key, especially when the key itself is a number
    // 1. assemble keys and values
    if (isMapping) {
      tempDataItem.push(keyIndexMap.indexOf(keys[i]));
    } else {
      tempDataItem.push(keys[i]);
    }
    tempDataItem.push(values[i]);
    // 2. assemble the precision of the value
    tempDataItem.push(valuePrecision);
    // 3. assemble the unit of the value
    tempDataItem.push(valueUnit);
    // 4. ready to return
    echartsData.push(tempDataItem);
  }
  return echartsData;
}

function isValid(detail) {
  detail.forEach((item) => {
    // 0. if detail is exist
    if (typeof item === undefined || typeof item === null)
      throw new Error('[ChartMapper] ChartDetailInvalid: Chart detail is null or undefined');
    // 1. if number of keys equals to the number of values
    if (item.chartOption.data[0].length !== item.chartOption.data[1].length)
      throw new Error('[ChartMapper] ChartDetailInvalid: Number of keys is not equal to the number of values');
    // 2. if the number of values is greater than 0
    if (item.chartOption.data[1].length <= 0)
      throw new Error('[ChartMapper] ChartDetailInvalid: Number of values should no less than 0');
    // TODO 3. series name is unique; 4.
  })
}

function truncateKeys(details) {
  details.forEach((detail) => {
    if(detail.isInfo) return ;
    let startTime = detail.startTime;
    let endTime = detail.endTime;
    getBetweenKV(detail.chartOption.data, startTime, endTime);
  })
}

function mergeData(details) {
  if(details.length === 1){
    details[0].chartOption.xAxisTags = details[0].chartOption.data[0].slice();
    return ;
  }
  // merge keys
  let keys1 = details[0].chartOption.data[0];
  let keys2 = details[1].chartOption.data[0];
  if (keys1.length >= keys2.length) {
    details[0].chartOption.xAxisTags = mergeKeys(details[0].chartOption.data[0], details[1].chartOption.data[0]);
  } else {
    details[0].chartOption.xAxisTags = mergeKeys(details[1].chartOption.data[0], details[0].chartOption.data[0]);
  }

  function mergeKeys(base, target) {
    // 合并两个数组
    let combined = base.concat(target);
    // 使用Set对象去除重复的元素
    let unique = new Set(combined);
    // 将Set对象转为数组并返回
    return Array.from(unique).slice();
  }
}

function extractPredict(details) {
  details.forEach((detail) => {
    if(!detail.chartOption.isPredict) return ;
    let start = detail.predictStartTime;
    let end = detail.predictEndTime;
    detail.chartOption.predictData = getBetweenKV(detail.chartOption.data, start, end, false, true);
  })
}

function getBetweenKV(data, start, end, isDirect = true, isExtract = false) {
  if(start === null || start === undefined || end === null || end === undefined) return ;
  let keys = data[0];
  let values = data[1];
  let isContain = false;
  let ret = [];
  for (let i = 0; i < keys.length; i++) {
    if (keys[i] == start) {
      isContain = true;
      ret[0] = [];
      ret[1] = [];
    }
    if (isContain) {
      ret[0].push(keys[i]);
      ret[1].push(values[i]);
      if (keys[i] == end) {
        isContain = false;
      }
      if (isExtract) {
        keys.splice(i, 1);
        values.splice(i, 1);
        i--;
      }
      if (!isContain) {
        break;
      }
    }
  }
  if (isContain) {
    console.warn('[ChartMapper] Warning: Data out of range');
  }
  if (isExtract) {
    data[0] = keys;
    data[1] = values;
  }
  if (isDirect) {
    data[0] = ret[0];
    data[1] = ret[1];
  } else {
    return ret;
  }
}

function modifyExtremum(details) {
  if(details.length === 1)  return ;
  details[0].chartOption.maxValue = Math.max(details[0].chartOption.maxValue, details[1].chartOption.maxValue);
  details[0].chartOption.minValue = Math.min(details[0].chartOption.minValue, details[1].chartOption.minValue);
}

export function toDetail(detail) {
  let ret = {};
  ret = detail;
  let tempArrKeys = [];
  let tempArrValues = [];
  // 1. 还原data
  detail.data.forEach((item, index) => {
    tempArrKeys.push(detail.xAxisTags[item[0]]);
    tempArrValues.push(formatNumber(item[1], item[2]));
  })
  ret.data = [tempArrKeys, tempArrValues];
  // 2. 删除ok标记和xAxisTags
  delete ret.isOK;
  delete ret.xAxisTags;
  return ret;
}