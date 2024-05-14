const express = require('express');
const path = require('path');
const app = express();

app.use(express.static(path.join(__dirname, './dist')));

// 当请求的文件不存在时，返回index.html文件
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
  '  - Local:   http://localhost:9095/ \n' +
  '  - Network: http://10.183.158.241:9095/\n')