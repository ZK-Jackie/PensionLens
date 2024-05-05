<template>
  <div id="app">
    <section class="head">
      <nav>
        <div class="nav-brand">
          <span>智算古稀</span>
        </div>
        <div class="nav-link">
          <ul>
            <li><router-link to="/nation">首页</router-link></li>
            <li><router-link to="/regin">区域信息</router-link></li>
            <li><router-link to="/policy">政策概况</router-link></li>
            <li><router-link to="/modify">参数调配</router-link></li>
          </ul>
        </div>
      </nav>

      <div class="text-box">
        <h1>养老保险测算大数据平台</h1>
      </div>

      <div class="container">
        <div class="box" v-for="(box, index) in boxes" :key="index">
          <div class="front">
            <div class="icon">
              <i :class="box.icon"></i>
            </div>
            <span>{{ box.title }}</span>
          </div>
          <div class="back">
            <p>{{ box.description }}</p>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      boxes: [
        {
          icon: 'fa fa-apple',
          title: '采用大数据挖掘和分析技术',
          description: '该平台利用大数据技术进行数据的收集、处理和分析，通过对海量的历史数据进行挖掘，揭示其中的关联性和趋势变化。通过应用数据挖掘算法，统计分析方法和机器学习算法，平台可以提取有价值的信息，并用于预测和决策支持。'
        },
        {
          icon: 'fa fa-google',
          title: '提供知识图谱构建和可视化展示',
          description: '基于养老金相关政策文件，该平台构建养老知识图谱。该知识图谱包括各种养老金相关政策、法规以及其之间的关系。通过应用自然语言处理和知识图谱技术，可以对政策文件进行语义分析和关系建模，形成结构化的知识图谱，并进行可视化展示，帮助用户更好地理解养老金政策和相应的规定。'
        },
        {
          icon: 'fa fa-windows',
          title: '提供实时数据分析和监控',
          description: '该平台结合实时数据处理和分析技术，能够及时收集和处理养老保险相关数据，并实时更新养老基金的运行情况。通过对关键指标的监控和预警系统的建立，平台可以及时发现潜在的风险和异常情况，为政府和保险公司提供决策参考和风险控制手段。'
        }
      ]
    };
  },
};
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.head {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  width: 100%;
  background-image: linear-gradient(rgba(4,9,30,0.7),rgba(4,9,30,0.7)),url("@/assets/homePage.jpg");
  background-position: center;
  background-size: cover;
  position: relative;
}

nav{
  display: flex;
  padding: 2% 6%;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  z-index: 100; /* 确保导航栏在上方 */
}

nav img {
  width: 150px;
}

.nav-link {
  flex: 1;
  text-align: right;
}

.nav-link ul li {
  list-style: none;
  display: inline-block;
  padding: 8px 12px;
  position: relative;
  color: #FFFFFF;
  text-decoration: none;
  font-size: 25px;
  cursor: pointer;
}

.nav-link ul li::after {
  content: '';
  width: 0;
  height: 2px;
  background: #8cc8ff;
  display: block;
  margin: auto;
  transition: 0.5s;
}

.nav-link ul li:hover::after {
  width: 100%;
}

.nav-brand {
  color: #FFFFFF;
  flex: 1;
  text-align: left;
  font-size: 30px;
}

.text-box {
  width: 90%;
  color: #FFFFFF;
  position: absolute;
  top: 20%; /* 根据需要调整 */
  left: 50%;
  transform: translate(-50%,-50%);
  text-align: center;
}

.text-box h1 {
  font-size: 62px;
}

.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-top: 80px; /* 根据需要调整 */
}

.box {
  width: 350px;
  margin: 30px;
  text-align: center;
  position: relative;
  transform-style: preserve-3d;
  perspective: 3000px;
}

.box .front {
  background-color: #fff;
  width: 100%;
  height: 220px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  box-shadow: 0 5px 20px rgba(0,0,0,0.1);
  transition: 0.5s ease;
}

.box:nth-child(1) .front {
  background-image: url('@/assets/flipBoxImg01.png');
}

.box:nth-child(2) .front {
  background-image: url('@/assets/flipBoxImg02.png');
}

.box:nth-child(3) .front {
  background-image: url('@/assets/flipBoxImg03.png');
}


.box .front .icon {
  height: 80px;
}


.box .front .icon i,
.box .front span {
  background: linear-gradient(220deg,#982727,#FFFFFF);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.box .front .icon i {
  font-size: 65px;
  font-weight: 900;
}

.box .front span,
.box .back span {
  font-size: 22px;
  font-weight: 600;
  text-transform: uppercase;
}

.box .back {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 1;
  width: 100%;
  height: 220px;
  background: linear-gradient(220deg,#02dbb0,#007adf);
  padding: 30px;
  color: #fff;
  opacity: 0;
  transform: translateY(110px) rotateX(-90deg);
  transition: 0.5s ease;
}

.box .back p {
  margin-top: auto;
  text-align: center;
  font-size: 17px;
  line-height: 23px;

}

.box:hover .front {
  opacity: 0;
  transform: translateY(-110px) rotateX(90deg);
}

.box:hover .back {
  opacity: 1;
  transform: translateY(0) rotateX(0);
}

.box .front .title {
  font-size: 24px; /* 调整文字大小 */
  text-align: center; /* 文字居中 */
}
</style>


