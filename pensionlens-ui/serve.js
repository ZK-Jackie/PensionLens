const express = require('express');
const path = require('path');
const app = express();
const os = require('os');
const {existsSync} = require("node:fs");

function getLocalIPAddresses() {
  const interfaces = os.networkInterfaces();
  for (const name of Object.keys(interfaces)) {
    for (const iface of interfaces[name]) {
      if (iface.family === 'IPv4') {
        if (!iface.internal) {
          return iface.address;
        }
      }
    }
  }
  return null;
}

function checkDist() {
  const distPath = path.join(__dirname, './dist');
  if (!existsSync(distPath)) {
    console.log('\n' +
      '  ====================================================================================================\n' +
      '  |                                                                                                  |\n' +
      '  |  Please run "npm run build" to generate the production environment before starting the service.  |\n' +
      '  |                                                                                                  |\n' +
      '  ====================================================================================================\n'
    )
    process.exit(1);
  }
}

function run() {
  // 静态资源服务
  app.use(express.static(path.join(__dirname, './dist')));
  // 当请求的文件不存在时，返回 index.html 文件，以支持 SPA 应用的 history 模式
  app.use((req, res) => {
    res.sendFile(path.join(__dirname, './dist', 'index.html'));
  });
  // 监听端口
  app.listen(9095);
  // 打印启动信息
  console.log(`🎉[${new Date()}] PensionLens-ui is successfully running in your computer` +
    '\n' +
    '    ____                  _             __                   \n' +
    '   / __ \\___  ____  _____(_)___  ____  / /   ___  ____  _____\n' +
    '  / /_/ / _ \\/ __ \\/ ___/ / __ \\/ __ \\/ /   / _ \\/ __ \\/ ___/\n' +
    ' / ____/  __/ / / (__  ) / /_/ / / / / /___/  __/ / / (__  ) \n' +
    '/_/    \\___/_/ /_/____/_/\\____/_/ /_/_____/\\___/_/ /_/____/  \n' +
    '                                                             \n' +
    '  App running at:\n' +
    '  - Local:   http://localhost:9095/');
  if (getLocalIPAddresses() !== null) {
    console.log(`  - Network: http://${getLocalIPAddresses()}:9095/\n`)
  }
}

function main() {
  checkDist();
  run();
}

main();