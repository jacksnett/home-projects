const path = require("path");

module.exports = {
  entry: "./title.js", 
  output: {
    filename: "main.js", 
    path: path.resolve(__dirname, "dist")
  }
};
