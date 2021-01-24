const path = require("path");

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
  }
};
