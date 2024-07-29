const express = require('express');
const path = require('path');
const app = express();
const os = require('os');

app.use(express.static(path.join(__dirname, './dist')));

// 当请求的文件不存在时，返回 index.html 文件，以支持 SPA 应用的 history 模式
app.use((req, res) => {
  res.sendFile(path.join(__dirname, './dist', 'index.html'));
});

app.listen(9095);

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
if(getLocalIPAddresses() !== null){
  console.log(`  - Network: http://${getLocalIPAddresses()}:9095/\n`)
}

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