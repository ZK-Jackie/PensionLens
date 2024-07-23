<template>
  <ul class="regin-info-settings">
    <li>
      <Block height="9rem" title="参数选择">
        <Selector :button-list="buttonList"
               @select="handleSelection"/>
      </Block>
    </li>
    <li>
      <Block height="6rem" width="100%" title="计划预览">
        <Preview/>
      </Block>
      <ul style="display: flex">
        <li style="width: 100%; margin-right: .15rem">
          <Block height="2.85rem" title="参数调配">
            <Modifier class="modifier"/>
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

export default {
  components: {
    Selector, Preview, Plan, Modifier
  },
  data() {
    return {
      buttonList: ['退休年龄', '参保率', '个人缴费率', '企业缴费率', '收缴率', '在岗平均工资',
        '个账记账利率', '过渡系数', '养老金增长率', '城镇化率', '就业率', '总和生育率'],
      chooseIndex: 0,
    }
  },
  methods: {
    handleSelection(index) {
      // console.log(index)
    }
  },
  mounted() {
    this.$nextTick(() => {
      if (!sessionStorage.getItem('modifier-reloaded')) {
        sessionStorage.setItem('modifier-reloaded', true);
        location.reload();
      } else {
        sessionStorage.removeItem('modifier-reloaded');
      }
    });
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