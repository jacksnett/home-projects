const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
  devServer: {
    contentBase: "./dist"
  },
  entry: {
    index : "./index.js"
  }, 
  mode: "development",
  output: {
    filename: "[name].js",
    path: path.resolve(__dirname, "dist") 
  },
  module: {
    rules: [
	{
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
    },
    {
    test: /\.js$/,
    exclude: /node_modules/,
    use: {
      loader: 'babel-loader',
    }}
]
  },
  plugins : [
    new HtmlWebpackPlugin()
  ],
  devServer: {
    contentBase: './dist'
  }
};
