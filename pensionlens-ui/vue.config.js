const {defineConfig} = require('@vue/cli-service')
const webpack = require('webpack')
const path = require("path");
const port = process.env.port || process.env.npm_config_port || 9095 // 端口
const name = process.env.VUE_APP_TITLE || '智算古稀' // 网页标题

function resolve(dir) {
    return path.join(__dirname, dir)
}

module.exports = defineConfig({
    // 默认情况下，Vue CLI 会假设你的应用是被部署在一个域名的根路径上
    publicPath: process.env.NODE_ENV === "production" ? "/" : "/",
    transpileDependencies: true,
    devServer: {
        host: '0.0.0.0',
        port: port,
        open: true,
        client: {
            webSocketURL: 'auto://0.0.0.0:0', // 关闭主机检查
            overlay: false, // 不要全屏报错
        },
        proxy: {
            //反向代理，前端解决跨域问题
            [process.env.VUE_APP_BASE_API]: {
                target: `http://localhost:8090`,
                changeOrigin: true,
                //重写路径
                pathRewrite: {
                    ['^' + process.env.VUE_APP_BASE_API]: ''
                }
            }
        },
    },
    css: {
        loaderOptions: {
            sass: {
                sassOptions: { outputStyle: "expanded" }
            }
        }
    },
    configureWebpack: {
        name: name,
        resolve: {
            alias: {
                '@': resolve('src')
            }
        },
        plugins: [
            new webpack.ProvidePlugin({
                $: 'jquery',
                jQuery: 'jquery'
            })
        ]
    },
})
