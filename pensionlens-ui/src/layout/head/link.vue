<script>
//引入外部链接辨别函数
import {isExternal} from '@/utils/validate'

export default {
  props: {
    to: {
      type: String,
      required: true,
    },
  },
  methods: {
    linkProp(dest){
      if(isExternal(dest)){
        //如果是外部链接，向组件返回一个新建窗口链接
        return {
          href: dest,
          target: '_blank'
        }
      }
    },
    type(){
      //如果是外部链接，返回a标签
      if(isExternal(this.to)){
        return 'a'
      }else{
        //如果是内部链接，返回router-link
        return 'router-link'
      }
    }
  }
}
</script>

<template>
  <!--type代表component的渲染类型-->
  <component :is="type" v-bind="linkProp(to)">
    <slot></slot>
  </component>
</template>
