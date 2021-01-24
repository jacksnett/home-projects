// Require the image
const image = require("./assets/image.png");

// Getting body element and create new image element
const bodyElement = document.querySelector("body");
const newImageElement = document.createElement("img");

// Set the new image element to the image we've required
newImageElement.src = image;

// Add the new image element as a child to the body element
bodyElement.appendChild(newImageElement);

