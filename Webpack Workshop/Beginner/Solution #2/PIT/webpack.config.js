const path = require("path");

module.exports = {
  entry: "./title.js", 
  output: {
    filename: "main.js",
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
