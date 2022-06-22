// vue.config.js
module.exports = {
    // https://cli.vuejs.org/config/#devserver-proxy
    devServer: {
        port: 4000,
        proxy: {
            '/api': {
                target: 'http://localhost:4100',
                ws: true,
                changeOrigin: true
            }
        }
    }
}