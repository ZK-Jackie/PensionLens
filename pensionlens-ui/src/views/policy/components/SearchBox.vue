<template>
<!--搜索框的包裹-->
  <div class="search-wrapper">
<!--搜索框的输入框-->
      <div class="input-holder">
        <input type="text" class="search-input" placeholder="请输入感兴趣的政策内容"/>
        <button class="search-icon" @click="searchToggle"><span></span></button>
      </div>
    </div>
</template>

<script>

export default {
  data(){
    return{
    }
  },
  methods:{
    searchToggle(evt){
      var container = $(evt.target).closest('.search-wrapper');
      if(!container.hasClass('active')){
        container.addClass('active');
        evt.preventDefault();
      }
      else {
        container.removeClass('active');
        // clear input
        container.find('.search-input').val('');
      }
    }
  }
}
</script>

<style scoped>
.search-wrapper {
  position: absolute;
  transform: translate(-50%, -50%);
  top:50%;
  left:50%;
}
.search-wrapper.active {
}
.search-wrapper .input-holder {
  height: 40px;
  width:40px;
  overflow: hidden;
  background: rgba(255,255,255,0); /* 修改这里 */
  border-radius:3px;
  position: relative;
  transition: all 0.3s ease-in-out;
}
.search-wrapper.active .input-holder {
  width:450px;
  height:45px;
  border-radius: 50px;
  transition: all .5s cubic-bezier(0.000, 0.105, 0.035, 1.570);
}
.search-wrapper .input-holder .search-input {
  width:100%;
  height: 38px;
  padding:0px 70px 0 20px;
  opacity: 0;
  position: absolute;
  top:0px;
  left:0px;
  background: transparent;
  box-sizing: border-box;
  border:none;
  outline:none;
  font-size: 16px;
  font-weight: 400;
  line-height: 20px;
  color:#FFF;
  transform: translate(0, 60px);
  transition: all .3s cubic-bezier(0.000, 0.105, 0.035, 1.570);
  transition-delay: 0.3s;
}
.search-wrapper.active .input-holder .search-input {
  opacity: 1;
  transform: translate(0, 10px);
}
.search-wrapper .input-holder .search-icon {
  width:35px;
  height:35px;
  border:none;
  border-radius:6px;
  margin: 8px;
  background: transparent;
  padding:0px;
  outline:none;
  position: relative;
  z-index: 2;
  float:right;
  cursor: pointer;
  transition: all 0.3s ease-in-out;
  filter: hue-rotate(200deg); /* 添加这一行 */
}
.search-wrapper.active .input-holder .search-icon {
  width: 35px;
  height:35px;
  margin: 8px;
  border-radius: 30px;
}
.search-wrapper .input-holder .search-icon span {
  width:30px;
  height:30px;
  display: inline-block;
  vertical-align: middle;
  position:relative;
  transform: rotate(45deg);
  transition: all .4s cubic-bezier(0.650, -0.600, 0.240, 1.650);
}
.search-wrapper.active .input-holder .search-icon span {
  transform: rotate(-45deg);
}
.search-wrapper .input-holder .search-icon span::before,
.search-wrapper .input-holder .search-icon span::after {
  position: absolute;
  content:'';
}
.search-wrapper .input-holder .search-icon span::before {
  width: 5px;
  height: 11px;
  left: 9px;
  top: 18px;
  border-radius: 2px;
  background: #FE5F55;
}
.search-wrapper .input-holder .search-icon span::after {
  width: 14px;
  height: 14px;
  left: 0px;
  top: 0px;
  border-radius: 16px;
  border: 4px solid #FE5F55;
}
.search-input::-webkit-input-placeholder {
  font-weight: bold;
}

/* Firefox */
.search-input::-moz-placeholder {
  font-weight: bold;
}

/* IE */
.search-input:-ms-input-placeholder {
  font-weight: bold;
}

</style>