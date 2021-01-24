const path = require("path");

module.exports = {
  entry: {
    first_entry_point_name: "./webpack_animation.js", 
    another_entry_point_name: "./alert_screen.js"
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
