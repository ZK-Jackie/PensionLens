<template>
  <div class="preview-views">
    <ul v-if="isLoadable1 && isLoadable2">
      <li>
        <Block class="preview-charts" height="4rem" width="4.182rem" title="不同生育模式下不同年龄的人数预测情况">
          <ul class="select-ul-1st" v-if="buttonIndex1[spotDetailMap[0]] !== undefined">
            <li v-for="(name, index) in buttonIndex1[spotDetailMap[0]]"
                :key="index"
                :class="{ active: buttonActive1[spotDetailMap[0]] === name }"
                class="button-list"
                style="font-size: 0.15rem"
                @click="handleButtonClick(spotDetailMap[0], name, 1)">{{ name }}
            </li>
          </ul>
          <ul class="select-ul-2nd" v-if="buttonIndex2[spotDetailMap[0]] !== undefined">
            <li v-for="(name, index) in buttonIndex2[spotDetailMap[0]]"
                :key="index" :class="{ active: buttonActive2[spotDetailMap[0]] === name }"
                style="font-size: 0.15rem"
                @click="handleButtonClick(spotDetailMap[0], name, 2)">{{ name }}
            </li>
          </ul>
          <Chart type="ring" :data="nowData[spotDetailMap[0]]" :key="nowData[spotDetailMap[0]][0].dataId"/>
        </Block>
      </li>
      <li>
        <Block class="preview-charts" height="4rem" width="4.182rem" title="广东省城镇养老保险未来收入和支出">
          <Chart type="bar" :data="nowData[spotDetailMap[1]]" :key="nowData[spotDetailMap[1]][0].dataId"/>
        </Block>
      </li>
      <li>
        <Block class="preview-charts" height="4rem" width="4.182rem" title="广东省城镇职工的参保人数">
          <Chart type="linear" :data="nowData[spotDetailMap[2]]" :key="nowData[spotDetailMap[2]][0].dataId"/>
        </Block>
      </li>
      <li>
        <Block class="preview-charts" height="4rem" width="4.182rem" title="人均基本养老金变化">
          <Chart type="climb" :data="nowData[spotDetailMap[3]]" :key="nowData[spotDetailMap[3]][0].dataId"/>
        </Block>
      </li>
      <li>
        <Block class="preview-charts" height="4rem" width="4.182rem" title="人均个人养老金情况">
          <ul class="select-ul-1st" v-if="buttonIndex1[spotDetailMap[4]] !== undefined">
            <li v-for="(name, index) in buttonIndex1[spotDetailMap[4]]"
                :key="index"
                :class="{ active: buttonActive1[spotDetailMap[4]] === name }"
                class="button-list"
                style="font-size: 0.15rem"
                @click="handleButtonClick(4, name, 1)">{{ name }}
            </li>
          </ul>
          <Chart type="rose" :data="nowData[spotDetailMap[4]]" :key="nowData[spotDetailMap[4]][0].dataId"/>
        </Block>
      </li>
      <li>
        <Block class="preview-charts" height="4rem" width="4.182rem" title="人均过渡养老金情况">
          <Chart type="rader" :data="nowData[spotDetailMap[5]]" :key="nowData[spotDetailMap[5]][0].dataId"/>
        </Block>
      </li>
    </ul>

    <Chart v-else width="20rem" height="10rem" type="loading" :data="[]" />

  </div>
</template>

<script>
import Chart from "@/components/chart.vue";

export default {
  components: { Chart },
  props: {
    loading: {
      type: Boolean,
      default: true
    },
    sdetails: {
      type: Array,
      default: () => {
        return []
      }
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
    sdetails: {
      handler: function (val) {
        this.$set(this, 'isLoadable2', false);
        try {
          this.reqData(val);
        }catch (e) {
          this.$message({
            message: '错误码：02 预览面板数据加载异常！',
            type: 'error',
            duration: 3000
          });
        }
      },
      immediate: true,
      deep: true
    }
  },
  mounted() {
    console.log('preview load');
  },
  data() {
    return {
      // 当前是否可被显示  外部+内部共同决定
      isLoadable1: false,
      isLoadable2: false,
      // 当前屏本身参数
      nowScreenId: 2,
      // 当前屏的所有详情
      totalDetails: [],
      totalData: {},
      // 当前屏所有按键状况
      buttonActive1: [],
      buttonActive2: [],
      buttonDataMap: {},
      buttonIndex1: [],
      buttonIndex2: [],
      // 当前屏的显示数据
      nowData: [],
      // detail和spot的映射
      spotDetailMap: []
    }
  },
  methods: {
    initData(){
      this.totalDetails = [];
      this.totalData = {};
      this.buttonActive1 = {};
      this.buttonActive2 = {};
      this.buttonDataMap = {};
      this.buttonIndex1 = {};
      this.buttonIndex2 = {};
      this.nowData = [];
      this.spotDetailMap = [];
    },
    reqData(res){
      this.initData();
      this.totalDetails = JSON.parse(JSON.stringify(res));
      this.preProcessDetail();
      this.$nextTick(() => {
        this.$set(this, 'isLoadable2', true);
      });
    },
    handleButtonClick(blockSpot, name, indexId){
      // 若按键没有变化，不进行任何操作
      if (indexId === 1 && this.buttonActive1[blockSpot] === name) {
        return;
      }else if (indexId === 2 && this.buttonActive2[blockSpot] === name) {
        return;
      }
      // 按键点击事件
      if (indexId === 1) {
        this.$set(this.buttonActive1, blockSpot, name);
      } else {
        this.$set(this.buttonActive2, blockSpot, name);
      }
      this.$nextTick(() => {
        let button_x = this.buttonActive1[blockSpot];
        let button_y = this.buttonActive2[blockSpot];
        // 如果有第二个按钮才是两级寻 id，一级的话使用一个 x 即可
        let pickDataId
        if (button_y !== undefined){
          pickDataId = this.buttonDataMap[blockSpot][button_x][button_y];
        } else {
          pickDataId = this.buttonDataMap[blockSpot][button_x];
        }
        // 根据需求取数据
        for (let i = 0; i < this.totalDetails[blockSpot].minDataUnit; i++) {
          this.$set(this.nowData[blockSpot], i, this.totalData[pickDataId]);
        }
      });
    },
    preProcessDetail(){
      // 准备渲染面板。即将初始化的内容有：
      // this.buttonDataMap，this.buttonIndex1，this.buttonIndex2，this.spotDetailMap
      // this.buttonActive1，this.buttonActive2，this.nowData，this.totalData
      // 1. 检查是否有按键面板
      this.totalDetails.forEach(item => {
        // 若有按键面板，构造按键、数据映射表，构造默认激活按键表
        if(item.isMultiOption){
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
            if (detail.dataName[1] !== undefined){
              this.buttonDataMap[item.detailId][detail.dataName[0]][detail.dataName[1]] = detail.dataId;
            }else{
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
        // 4. 将当前detail的所有数据根据 spotId 加载到spotDetailMap中
        this.spotDetailMap.push(item.detailId);
      });
    }
  },
}
</script>

<style scoped lang="scss">
/********中央预览面板********/
.preview-views {
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;  //灵活换行
}

.preview-views > ul {
  display: flex;
  flex-wrap: wrap;
  position: relative;
  width: 100%;
  overflow: auto;
  max-height: 5.2rem;
}

/* 隐藏滚动条 */
.preview-views > ul::-webkit-scrollbar {
  display: none;
}

.preview-views > ul > li {
  position: relative;
}

.preview-views .preview-charts {
  margin: 0.1rem;
}

/*******选择按键*******/
.select-ul-2nd {
  position: absolute;
  width: 1rem;
  right: 0;
  bottom: 0.2rem;
  z-index: 999;
}

.select-ul-2nd > li {
  height: 0.4rem;
  line-height: 0.4rem;
  padding-left: 10px;
  box-sizing: border-box;
  background-color: rgba(14, 148, 234, 0.2);
  cursor: default;
  color: #cdddf7;
}

.select-ul-2nd > li.active {
  color: white;
  background: #0e94eb;
}

.select-ul-1st {
  position: absolute;
  width: 1rem;
  bottom: 0.2rem;
  left: 0;
  z-index: 999;
}

.select-ul-1st > li {
  height: 0.4rem;
  line-height: 0.4rem;
  padding-left: 10px;
  box-sizing: border-box;
  background-color: rgba(14, 148, 234, 0.2);
  cursor: default;
  color: #cdddf7;
}

.select-ul-1st > li.active {
  color: white;
  background: #0e94eb;
}
</style>
