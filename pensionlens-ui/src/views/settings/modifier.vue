<template>
  <div v-if="isLoadable1 && isLoadable2">
    <div class="modifier-top">
      <el-select v-model="buttonActive1[detailList[select]]"
                 @change="handleSelectorChange"
                 :disabled="buttonActive1[detailList[select]] === undefined"
                 placeholder="请选择">
        <el-option
            v-for="item in buttonIndex1[detailList[select]]"
            :key="item+'-button'"
            :label="item"
            :value="item">
        </el-option>
      </el-select>
      <el-button type="primary"
                 plain
                 @click="reqData(mdetails)"
                 style="margin-left: 0.1rem">
        重置
      </el-button>
      <el-button type="success" plain
                 @click="commitData()">
        保存
      </el-button>
    </div>
    <Chart class="modifier-mid"
           :type="nowData[detailList[select]][0].displayMode[0]"
           :data="nowData[detailList[select]]"
           :key="nowData[detailList[select]][0].dataId"
           style="height: 1.7rem"/>
  </div>
  <div v-else>
    <Chart type="loading" :data="[]"/>
  </div>
</template>
<script>
import Chart from "@/components/chart.vue";

export default {
  name: "Modifier",
  components: {Chart},
  props: {
    select: {
      type: Number
    },
    mdetails: {
      type: Array,
      default: () => []
    },
    loading: {
      type: Boolean,
      default: true
    }
  },
  watch: {
    loading: {
      handler: function (val) {
        this.isLoadable1 = !val;
      },
      immediate: true,
      deep: true
    },
    mdetails: {
      handler: function (val) {
        this.isLoadable2 = false;
        this.reqData(val);
      },
      immediate: true,
      deep: true
    },
  },
  data() {
    return {
      // 历史选中的 detailId
      hisSelect: 0,
      // 当前大屏显示状况
      isLoadable1: false,
      isLoadable2: false,
      // 当前屏参数
      nowScreenId: 4,
      // 当前屏的所有详情
      totalDetails: [],
      totalData: {},
      // 当前屏所有选择器状况
      buttonActive1: [],
      buttonActive2: [],
      buttonDataMap: {},
      buttonIndex1: {},
      buttonIndex2: {},
      // 当前屏的显示数据
      detailList: [],     // 当前屏幕有哪些 detailId
      nowData: {},        // 当前屏幕展示的数据
    }
  },
  methods: {
    handleSelectorChange() {
      // 当前选中的目标的 id
      let nowSelectDetailId = this.detailList[this.select];
      // 当前选中的选项
      let aimOption = this.buttonActive1[nowSelectDetailId];
      // 目标选项的数据 id
      let aimDataId = this.buttonDataMap[nowSelectDetailId][aimOption];
      // 将目标数据 id 的数据加载到 nowData 中
      this.$set(this.nowData, nowSelectDetailId, [this.totalData[aimDataId]]);
    },
    commitData() {
      // 1. 获取当前选中的 detailId
      let nowConfirmDetailId = this.detailList[this.select];
      // 2. 获取当前选中的 detailId 的 dataId
      let nowConfirmDataId = this.nowData[nowConfirmDetailId][0].dataId;
      // 3. 保存到 totalData 中
      this.totalData[nowConfirmDataId].data = this.nowData[nowConfirmDetailId][0].data;
      // 4. 报告给上一级
      this.$emit('commit', this.totalData);
    },
    reqData(res) {
      this.isLoadable2 = false;
      this.totalDetails = JSON.parse(JSON.stringify(res));
      this.preProcessDetail();
      setTimeout(() => {
        this.isLoadable2 = true;
      }, 500);
    },
    preProcessDetail() {
      // 准备渲染面板。即将初始化的内容有：
      // this.buttonDataMap，this.buttonIndex1，this.buttonIndex2，this.detailList，
      // this.buttonActive1，this.buttonActive2，this.nowData，this.totalData
      // 1. 检查是否有按键面板
      this.totalDetails.forEach(item => {
        // 填充 detailList
        this.detailList.push(item.detailId);
        // 若有按键面板，构造按键、数据映射表，构造默认激活按键表
        if (item.isMultiOption) {
          // 初始化按键索引——确定两个按键组每个按键叫什么名字；初始化按键、数据映射二维表——确定两个按键对应一个数据；
          this.buttonDataMap[item.detailId] = {};
          item.detailData.forEach(detail => {
            // 初始化当前 detail 按键索引1，值为dataName
            if (this.buttonIndex1[item.detailId] === undefined) {
              this.$set(this.buttonIndex1, item.detailId, []);
            }
            if (!this.buttonIndex1[item.detailId].includes(detail.dataName[0])) {
              this.buttonIndex1[item.detailId].push(detail.dataName[0]);
            }
            // 初始化当前 detail 按键索引2，值为dataName
            if (this.buttonIndex2[item.detailId] === undefined) {
              this.$set(this.buttonIndex2, item.detailId, []);
            }
            if (!this.buttonIndex2[item.detailId].includes(detail.dataName[1])) {
              this.buttonIndex2[item.detailId].push(detail.dataName[1]);
            }
            // 二位表的横纵坐标分别为dataName的第一个参数和第二个参数，值为dataId
            if (!(detail.dataName[0] in this.buttonDataMap[item.detailId])) {
              this.$set(this.buttonDataMap[item.detailId], detail.dataName[0], {});
            }
            // 如果有第二个 dataName 就两层 button
            if (detail.dataName[1] !== undefined) {
              this.buttonDataMap[item.detailId][detail.dataName[0]][detail.dataName[1]] = detail.dataId;
            } else {
              this.buttonDataMap[item.detailId][detail.dataName[0]] = detail.dataId;
            }
          });
          // 默认激活按键表，第一个值为buttonIndex1的第一个值，第二个值为buttonIndex2的第一个值，值为dataName
          this.buttonActive1[item.detailId] = this.buttonIndex1[item.detailId][0];
          this.buttonActive2[item.detailId] = this.buttonIndex2[item.detailId][0];
        }
        // 2. 将当前detail应当展示的数据加载到nowData中
        let tempArr = [];
        for (let i = 0; i < item.minDataUnit; i++) {
          tempArr.push(item.detailData[i]);
        }
        this.nowData[item.detailId] = JSON.parse(JSON.stringify(tempArr));
        // 3. 将当前detail的所有数据根据 dataId 加载到totalData中
        item.detailData.forEach(data => {
          this.totalData[data.dataId] = data;
        });
      });
    }
  },
  mounted() {

  },
}
</script>

<style scoped>
.modifier-top {
  align-items: center;
  margin-bottom: .1rem;
}
</style>
