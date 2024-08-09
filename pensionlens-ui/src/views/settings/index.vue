<template>
  <ul class="regin-info-settings" v-if="isLoadable">
    <li>
      <Block height="9rem" title="参数选择">
        <Selector :button-list="buttonList"
               @select="handleSelection"/>
      </Block>
    </li>
    <li>
      <Block height="6rem" width="100%" title="计划预览">
        <Preview :loading="isPreviewLoading" :sdetails="previewScreenDetails" :key="previewRefresh"/>
      </Block>
      <ul style="display: flex">
        <li style="width: 100%; margin-right: .15rem">
          <Block height="2.85rem" title="参数调配">
            <Modifier class="modifier"
                      :loading="false"
                      :select="selectIndex"
                      :mdetails="modifierScreenDetails"
                      @commit="handleCommit"
            />
          </Block>
        </li>
<!--        <li style="width: 30%">-->
<!--          <Block height="2.85rem" title="计划调配">-->
<!--            <Plan/>-->
<!--          </Block>-->
<!--        </li>-->
      </ul>
    </li>
  </ul>
</template>

<script>
import Selector from "./selector.vue";
import Preview from "./preview.vue";
import Plan from "./plan.vue";
import Modifier from "./modifier.vue";
import {UUID} from "@/utils/string";

export default {
  components: {
    Selector, Preview, Plan, Modifier
  },
  data() {
    return {
      // 是否载入
      isLoadable: false,
      // 当前大屏
      nowScreenId: 3,
      // 按钮面板
      buttonList: ['退休年龄', '参保率', '个人缴费率', '企业缴费率', '收缴率', '在岗平均工资',
        '个账记账利率', '过渡系数', '养老金增长率', '城镇化率', '就业率', '总和生育率'],
      chooseIndex: 0,
      // 预览面板
      localScreenId: 2,
      selectIndex: 0,
      isPreviewLoading: true,
      previewRefresh: "previewRefreshInitVal",
      previewScreenDetails: [],
      // 调参面板
      modifierScreenId: 4,
      isModifierLoading: true,
      modifierScreenDetails: [],
    }
  },
  methods: {
    reqData(){
      // 预览面板
      this.$store.dispatch('GetScreenDetail', this.localScreenId).then(res => {
        this.previewScreenDetails = JSON.parse(JSON.stringify(res));
        // 给预览面板传递数据
        this.isPreviewLoading = false;
      }).catch(err => {
        console.error(err)
      });

      // 调参面板
      this.$store.dispatch('GetScreenDetail', this.modifierScreenId).then(res => {
        this.modifierScreenDetails = JSON.parse(JSON.stringify(res));
        // 给调参面板传递数据
        this.isModifierLoading = false;
      }).catch(err => {
        console.error(err)
      });
    },
    handleSelection(index){
      this.selectIndex = index;
    },
    handleCommit(val){
      this.isPreviewLoading = true;
      this.$message({
        message: '同步测算中...',
        type: 'info',
        duration: 3000
      });
      this.$store.dispatch("CommitModiData", val).then(res => {
        // 载入数据
        this.previewScreenDetails = JSON.parse(JSON.stringify(res));
        setTimeout(() => {
          this.$message({
            message: '测算执行完成',
            type: 'success',
            duration: 3000
          });
          this.isPreviewLoading = false;
          this.previewRefresh = UUID();
        }, 5000);
      });
    }
  },
  mounted() {
    this.reqData()
    this.isLoadable = true
  },
}
</script>

<style scoped>
.regin-info-settings > li {
  float: left;
  padding: 0 .1rem;
  width: 30%;
}

.regin-info-settings > li:nth-child(2) {
  width: 70%;
  padding: 0
}

.modifier {
  height: 100%;
  width: 100%;
}
</style>