<template>
  <div class="animation">
    <div class="animation-canvas">
      <canvas ref="animationCanvasRef"></canvas>
    </div>
    <div class="animation-text">智算  古稀</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      c: null,
      $: null,
      t: 0,
      arr: [],
      num: 300,
      w: 0,
      h: 0
    };
  },
  mounted() {
    this.c = this.$refs.animationCanvasRef;
    this.$ = this.c.getContext('2d');
    this.w = this.c.width = window.innerWidth;
    this.h = this.c.height = window.innerHeight * 1.5;
    this.generate(700);
    window.addEventListener('resize', this.handleResize);
    this.init();
  },
  methods: {
    generate(q) {
      for (let i = 0; i < q; i++) {
        this.arr.push({
          x: Math.random() * 2 * this.w,
          y: Math.random() * 2 * this.h,
          len: Math.max(Math.random() * 3, 0.5),
          alpha: 0.8
        });
      }
    },
    regenerate(a) {
      const n = this.arr[a];
      n.x = Math.random() * this.w;
      n.y = Math.random() * this.h;
      n.len = Math.max(Math.random() * 2, 0.5);
      n.alpha = 0.8;
    },
    paint(a) {
      const n = this.arr[a];
      const radgrad = this.$.createRadialGradient(n.x, n.y, 0, n.x, n.y, n.len * 8);
      radgrad.addColorStop(0, `hsla(${a},90%,50%,1)`);
      radgrad.addColorStop(0.25, `hsla(${a},90%,50%,.25)`);
      radgrad.addColorStop(0.5, `hsla(${a},90%,50%,.05)`);
      radgrad.addColorStop(1, `hsla(${a},90%,50%,0)`);
      this.$.fillStyle = radgrad;
      this.$.beginPath();
      this.$.arc(n.x, n.y, n.len * 8, 0, 2 * Math.PI);
      this.$.closePath();
      this.$.fill();
      this.$.fillStyle = `hsla(${a},90%,60%,0.8)`;
      this.$.beginPath();
      this.$.arc(n.x, n.y, n.len, 0, 2 * Math.PI);
      this.$.closePath();
      this.$.fill();
    },
    move(a) {
      const n = this.arr[a];
      n.x += Math.sin((n.x / this.w) * 2 * Math.PI) * 2 * Math.max(Math.abs(1.5 * Math.sin(this.t * 0.125 * Math.PI)), 1) * n.len;
      n.y += Math.sin((n.y / this.h) * 2 * Math.PI) * 2 * Math.max(Math.abs(1.5 * Math.sin(this.t * 0.125 * Math.PI)), 1) * n.len;
      n.alpha = Math.sin((Math.abs(n.x - (this.w / 2))) / (this.w / 2) * Math.PI);
      if (n.alpha <= 0.01) this.regenerate(a);
    },
    go() {
      this.$.fillStyle = "rgba(0,0,0,0.9)";
      this.$.fillRect(0, 0, this.w, this.h);
      for (let i = 0; i < this.arr.length; i++) {
        this.paint(i);
        this.move(i);
      }
    },
    init() {
      requestAnimationFrame(this.init);
      this.go();
      this.t += 0.01;
    },
    handleResize() {
      this.w = this.c.width = window.innerWidth;
      this.h = this.c.height = window.innerHeight * 1.5;
    }
  },
  beforeDestroy() {
    window.removeEventListener('resize', this.handleResize);
  }
};
</script>

<style scoped lang="scss">

.animation {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
    -webkit-filter:brightness(1)  saturate(0.9);
    position:absolute;
    top: 0;
    left: 0;
    overflow: hidden;
}

.animation-canvas {
  -webkit-filter:brightness(1)  saturate(0.9);
  position:absolute;
  top: 0;
  left: 0;
  overflow: hidden;
}

body {
  margin: 0;
  background:#000;
  padding: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
}

@-webkit-keyframes cinematic
{
  0%{transform:rotateZ(20deg);}
  75%{opacity:1;}
  100%{transform:rotateZ(-20deg);opacity:0;}
}

.animation-text {
  color: #fff;
  font-size: 70px;
  letter-spacing: 15px;
  text-transform: uppercase;
  display: flex;
  justify-content: center;
  align-items: center;
  line-height: 76px;
  outline: none;
  --c: lightseagreen;
  text-shadow: 0 0 10px var(--c),
  0 0 20px var(--c),
  0 0 40px var(--c),
  0 0 80px var(--c),
  0 0 160px var(--c);
  animation: animate 2s linear infinite;
}

@-webkit-keyframes zoom
{
  0%{
    opacity:0;
    transform:scale(0.5) translateY(-50%);
    -webkit-filter:blur(10px);
  }
  75%
  {
    opacity:1; transform:scale(1) translateY(-50%);
    -webkit-filter:none;
  }
  90%{
    -webkit-filter:none;
    opacity:1;
  }
  95%{
    opacity:0.3;
    transform:scale(1.5) translateY(-50%);
    -webkit-filter:blur(10px);
  }
  100%{
    opacity:0;
    transform:scale(2);
  }
}

@keyframes animate {
  to {
    filter: hue-rotate(360deg);
  }
}
</style>

