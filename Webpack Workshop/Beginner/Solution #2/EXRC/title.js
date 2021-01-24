// Require the css file
require("./index.css");

// Getting body element
const bodyElement = document.querySelector("body");

// Write the html to the page
bodyElement.innerHTML = `<div class="container">
<div class="scene">
    <div class="webpack-cube">
        <div class="outer-cube">
            <div class="face face-top"></div>
            <div class="face face-bottom"></div>
            <div class="face face-left"></div>
            <div class="face face-right"></div>
            <div class="face face-front"></div>
            <div class="face face-back"></div>
        </div>
        <div class="inner-cube">
            <div class="face face-top"></div>
            <div class="face face-bottom"></div>
            <div class="face face-left"></div>
            <div class="face face-right"></div>
            <div class="face face-front"></div>
            <div class="face face-back"></div>
        </div>
    </div>
    <div class="shadows-outer-container">
        <div class="shadow-outer"></div>
        </div>
    <div class="shadows-inner-container">
        <div class="shadow-inner"></div>
    </div>
</div>
</div>`;

