const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
  entry: {
    animation : "./webpack_animation.js",
    alertScreen: "./alert_screen.js"
  }, 
  output: {
    filename: "[name].js",
    path: path.resolve(__dirname, "dist") 
  },
  module: {
    rules: [{
      test: /\.png$/,
      use : [{
        loader: "file-loader",
        options: {
          outputPath: "assets",
          publicPath: "dist/assets"
        }
      }]
    },
    {
      test: /\.css$/,
      use: ["style-loader", "css-loader"]
    }]
  },
  plugins : [
    new HtmlWebpackPlugin()
  ],
  devServer: {
    contentBase: "./dist",
    proxy: {
      '/api': 'http://localhost:9000'
    }
  }
};
