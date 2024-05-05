<script>
import {UUID} from "@/utils/string";
import {graph} from "@/api/data/graph_data";

export default {
  name: 'Graph',
  props: {
    id: {
      type: String,
      required: false,
      default: UUID()
    },
    /**
     * the specific data and style of the chart
     * @type {Array} Need an array consists of max to two JSON elements
     */
  },
  data() {
    return {
      chart: null,
      currentStep: 0,  // 新增的属性
    };
  },
  mounted() {
    this.loadChart();
    this.timer = setInterval(this.handleTimer, 2000);
  },
  beforeDestroy() {
    clearInterval(this.timer);
  },
  methods: {
    handleTimer() {
      if (this.currentStep < graph.nodes.length) {
        this.currentStep++;
        this.loadChart();
      } else {
        clearInterval(this.timer);  // 如果所有节点都已经显示，那么清除定时器
      }
    },
    loadChart() {
      const chart = this.$echarts.init(document.getElementById('chart-item-map-' + this.id));

      const option = {
        title: {
          text: '养老保险政策',
          subtext: 'Default layout',
          top: 'bottom',
          left: 'right',
          textStyle: {
            fontSize: 20,  // 设置标题的字体大小
            color:'#66b3ff',
          }
        },
        tooltip: {
          formatter: function (params) {
            if (params.dataType === 'node') {
              // 对于节点，第一行展示节点的 names 属性，第二行展示小圆点和小圆点的属性名字
              return params.data.name + '<br/>' + params.marker + graph.categories[params.data.category].name;
            } else if (params.dataType === 'edge') {
              // 对于边，第一行展示【起始节点name属性名字】【边的name属性名字】【终止节点的name属性名字】
              let sourceNode = graph.nodes.find(node => node.id == params.data.source);
              let targetNode = graph.nodes.find(node => node.id == params.data.target);
              return sourceNode.name + ' -- ' + params.data.name + ' --> ' + targetNode.name;
            }
          }
        },
        legend: [
          {
            // selectedMode: 'single',
            data: graph.categories.map(function (a) {
              return a.name;
            }),
            inactiveColor: 'rgba(255,255,255,.2)',  // 未激活时的颜色
            textStyle: {
              color: "#66b3ff"  // 激活时的颜色
            },
            fontSize: 12,
          }
        ],
        animationDuration: 1800,
        animationEasingUpdate: 'quinticInOut',
        series: [
          {
            name: '养老保险政策',
            type: 'graph',
            layout: 'force',
            force: {
              repulsion: 1500,
              edgeLength: 10,
              layoutAnimation: true
            },
            // data: graph.nodes,
            // links: graph.links,
            data: graph.nodes.slice(0, this.currentStep),  // 只显示前 currentStep 个节点
            links: graph.links.slice(0, this.currentStep),  // 只显示前 currentStep 个边
            categories: graph.categories,
            roam: true,
            label: {
              show: true,
              position: 'inside',
              color: 'rgba(255,255,255,.8)',
              formatter: function (params) {
                let name = params.data.name;
                let formattedName = '';
                let lineCount = 0;
                for (let i = 0; i < name.length; i++) {
                  if (i > 0 && i % 5 === 0) {
                    lineCount++;
                    if (lineCount >= 2) {
                      formattedName += '...';
                      break;
                    }
                    formattedName += '\n';
                  }
                  formattedName += name[i];
                }
                return formattedName;
              }
            },
            edgeLabel: {
              show: true,  // 始终显示边的标签
              position: 'middle',  // 边的标签位置
              formatter: function (params) {
                return params.data.name;  // 显示边的 name 属性
              },
              textStyle: {
                color: 'rgba(0,255,255,.8)',
                fontSize: 13,
                fontWeight: 'bold'
              }
            },
            lineStyle: {
              color: 'source',
              curveness: 0.3
            },
            emphasis: {
              focus: 'adjacency',
              lineStyle: {
                width: 10
              }
            }
          }
        ]
      }
      chart && chart.setOption(option);
    },
  },
};
</script>

<template>
    <div class="chart-item-map"
         :id="'chart-item-map-'+ id"
         style="width: 100%; height: 100%;"></div>
</template>